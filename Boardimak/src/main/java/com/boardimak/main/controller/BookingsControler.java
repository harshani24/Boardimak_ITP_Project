package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boardimak.main.model.Blogs;
import com.boardimak.main.model.Bookings;
import com.boardimak.main.model.CmsOther;
import com.boardimak.main.model.Property;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.model.User;
import com.boardimak.main.model.Users;
import com.boardimak.main.services.BookingNotifications;
import com.boardimak.main.services.BookingsServices;
import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.PropertyService;
import com.boardimak.main.services.UserService;



@Controller
public class BookingsControler {

	@Autowired
	private BookingsServices bookingsServices;
	
	@Autowired
	private BookingNotifications bookNoti;
	
	@Autowired
	private UserService usersService;
	
	@Autowired
	private PropertyService proService;
	
	
	private Logger logger = LoggerFactory.getLogger(BookingsControler.class);
	
	@GetMapping("/bookingsHomestu")
	public String BookingsHomestu(HttpServletRequest request, Principal principal) {
		
		request.setAttribute("users", usersService.findByEmail( principal.getName()));
		request.setAttribute("bookings", bookingsServices.findAllBookings());
		return "parstu-all-bookings";
	}
	
	@GetMapping("/bookingsHomesOwner")
	public String BookingsHomesOwner(HttpServletRequest request, Principal principal) {
		request.setAttribute("bookings", bookingsServices.findAllBookings());
		request.setAttribute("users", usersService.findByEmail( principal.getName()));
		return "owner-all-bookings";
	}
	
	@GetMapping("/bookingsOwnerViewSingleBooking")
	public String BookingsOwnerViewSingle(@RequestParam int id, HttpServletRequest request, HttpServletResponse res) throws IOException {
		request.setAttribute("bookings", bookingsServices.findOneBookings(id));
		return "owner-view-booking";
	}
	
	
	@GetMapping("/deleteBookingsPar")
	public void deleteBlog(@RequestParam int id, HttpServletRequest request, HttpServletResponse res) throws IOException {
		bookingsServices.deleteBookigs(id);
		res.sendRedirect("/bookingsHomestu");
	}
	
	@GetMapping("/deleteBookingsOwner")
	public void deleteBlogOwner(@RequestParam int id, HttpServletRequest request, HttpServletResponse res) throws IOException {
		Bookings b = bookingsServices.findOneBookings(id);
		b.setStatus("Reject");
		bookingsServices.saveBookings(b);
		res.sendRedirect("/bookingsHomesOwner");
		
	}
	
	
	@GetMapping("/sigleProperty")
	public String SigleProperty(@RequestParam int id, HttpServletRequest request) {
		/* request.setAttribute("bookings", bookingsServices.findOneBookings(id)); */
		
		Property p = proService.getAProperty(id);
		String a = Integer.toString(p.getId());
		request.setAttribute("property",p);
		request.setAttribute("pid",a);
		return "single-property-stuPar";
	}
	

	@RequestMapping(value = "/displayImageBook/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		List<Property> list = proService.showAll();
		
		for(Property property : list) {
			if(property.getId()==id) {
			byte[] ph = property.getData();
			InputStream inputStream = new ByteArrayInputStream(ph);
			IOUtils.copy(inputStream, response.getOutputStream());
			}
		}
		
	}
	
	@PostMapping("/bookaProperty")
	public void saveBlog(@ModelAttribute Bookings bookings, HttpServletRequest request, HttpServletResponse res, Principal principal)
			throws IOException {

		String a = ((usersService.findByEmail( principal.getName())).getFirstName() ) + " " + (usersService.findByEmail( principal.getName()) ).getLastName();
		String b = ((usersService.findByEmail( principal.getName())).getEmail());
		int c =  ((usersService.findByEmail( principal.getName())).getId());
		
		System.out.println(c);
		bookings.setUserID(c);
//		bookings.setPropertyID("10098");
		
		System.out.println(bookings.getPropertyID());
		
		int d = Integer.parseInt(bookings.getPropertyID());
		
		Property p = proService.getAProperty(d);
		int f = p.getOwnerId();
		
		String g = Integer.toString(p.getOwnerId());	
		User e = usersService.findOne(f);
		String ema = e.getEmail();
		
		
		bookings.setOwner_name(e.getFirstName());
		bookings.setOwner_email(ema);
		bookings.setUser_Name(a);
		bookings.setUser_email(b);
		
		bookings.setOwnerID(g);
		bookingsServices.saveBookings(bookings);
		try {
			bookNoti.sendNotificationsToUser(bookings);	
		}catch(MailException ew) {
			logger.info("Error sending Email" + ew.getMessage());
		}
		
		try {

			bookNoti.sendNotificationsToOwner(bookings);	
		}catch(MailException ew) {
			logger.info("Error sending Email" + ew.getMessage());
		}
		
		res.sendRedirect("/bookingsHomestu");
	}
	
	
	@GetMapping("/editBookings")
	public String editBookings(@RequestParam int id, HttpServletRequest request) {
		
		Bookings b = bookingsServices.findOneBookings(id);
		request.setAttribute("bookings", bookingsServices.findOneBookings(id));
		
		int s = Integer.parseInt(b.getPropertyID());
		
		Property p = proService.getAProperty(s);
		
		request.setAttribute("property",p);
		
		bookingsServices.deleteBookigs(id);
		return "single-property-stuPar";
	}
	
	@PostMapping("/ownerChangesBookingStatus")
	public void ownerChangeBookingStatus(@ModelAttribute Bookings bookings, HttpServletRequest request, HttpServletResponse res)
			throws IOException {

		
		bookingsServices.saveBookings(bookings);
		try {
			bookNoti.sendNotificationsToUserStatus(bookings);	
		}catch(MailException e) {
			logger.info("Error sending Email" + e.getMessage());
		}
		
		
		
		res.sendRedirect("/bookingsHomesOwner");
	}
	
	 @RequestMapping(value = "/bookingsReport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> bookingsReport(Principal principal) {

	        List<Bookings> bookings = bookingsServices.findAllBookings();
	        List<Bookings> book = new ArrayList();
	        User us = usersService.findByEmail( principal.getName());
	        
	        for(Bookings books : bookings) {
	        	
	        	if (us.getId() == books.getUserID()) {
	        		book.add(books);
				}
	        	
			/*
			 * String a = (String)books.getOwnerID();
			 * 
			 * if(a.equals("2")){ book.add(books); }
			 */
	        }

	        ByteArrayInputStream bis = GeneratePdfReport.bookingsReport(book);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 @RequestMapping(value = "/bookingsReportOwner", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> bookingsReportOwner(Principal principal) {

	        List<Bookings> bookings = bookingsServices.findAllBookings();
	        List<Bookings> book = new ArrayList();
	        User us = usersService.findByEmail( principal.getName());
	        
	        for(Bookings books : bookings) {
	        	
	        	if (us.getId() == Integer.parseInt(books.getOwnerID())) {
	        		book.add(books);
				}
	        	
			/*
			 * String a = (String)books.getOwnerID();
			 * 
			 * if(a.equals("2")){ book.add(books); }
			 */
	        }

	        ByteArrayInputStream bis = GeneratePdfReport.bookingsReport(book);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 
	
}
