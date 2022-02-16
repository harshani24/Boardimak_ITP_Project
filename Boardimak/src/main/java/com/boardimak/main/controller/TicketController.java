package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boardimak.main.model.ReplyTicket;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.model.User;
import com.boardimak.main.services.GeneratePdfReport;
//import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.NotificationService;
import com.boardimak.main.services.PropertyService;
import com.boardimak.main.services.TicketReplyService;
import com.boardimak.main.services.TicketService;
import com.boardimak.main.services.UserService;

@Controller
public class TicketController {
	
	private Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private  TicketReplyService ticketreplyservice;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserService usersService;


	

	/* -----------------------------USER CONTROL--------------------*/
	
	@GetMapping("/ticket")
	public String showTickets(HttpServletRequest request, Model model, Principal principal) {
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("tickets",ticketService.ShowAllTickets());
		request.setAttribute("mode", "MODE_TICKET");
		return "support-ticket";
	}
		
	@GetMapping("/create-ticket")
	public String Registration(HttpServletRequest request, Model model, Principal principal) {
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("mode", "MODE_REGISTER");
		return "support-ticket";
	}
	
	@PostMapping("/save-user")
	public String registerTicket(@ModelAttribute Ticket ticket1, BindingResult bindingResult, HttpServletRequest request,Principal principal) {
		ticketService.saveMyTicket(ticket1);
		
		try {
			Ticket ticket = new Ticket();
			notificationService.sendNotification(ticket);	
		}catch(MailException e) {
			logger.info("Error sending Email" + e.getMessage());
		}
		if(principal != null) {
			request.setAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("tickets",ticketService.ShowAllTickets());
		request.setAttribute("mode", "MODE_TICKET");
		return "support-ticket";
	}

	
	@RequestMapping("/delete-user")
	public String deleteTicket(@RequestParam int id,HttpServletRequest request, Model model, Principal principal) {
		ticketService.deleteMyTickets(id);
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("tickets",ticketService.ShowAllTickets());
		request.setAttribute("mode", "MODE_TICKET");
		return "support-ticket";
	}
	
	@RequestMapping("/edit-user")
	public String editTicket(@RequestParam int id, HttpServletRequest request, Model model, Principal principal) {
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "support-ticket";
	}
	
	@GetMapping("/open-Userticket")
	public String OpenUserTicket(@RequestParam int id,HttpServletRequest request,Model model, Principal principal) {
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("replys",ticketreplyservice.ShowReply());
		request.setAttribute("mode", "OPEN_USERTICKET");
		return "support-ticket";
	}
	
	@GetMapping("/ticket-UserReply")
	public String UserTicketReply(@RequestParam int id,HttpServletRequest request,Principal principal) {
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		if(principal != null) {
			request.setAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("replys",ticketreplyservice.ShowReply());
		request.setAttribute("mode", "OPEN_USERREPLY");
		return "support-ticket";
	}
	@GetMapping("/closeTicket")
	public void closeTicket(HttpServletResponse res) throws IOException {
		res.sendRedirect("/ticket");
		
	}
	
	
/* -----------------------------ADMIN CONTROLE--------------------*/
	
	@GetMapping("/show-ticket")
	public String showAllTicket(HttpServletRequest request, Model model, Principal principal) {
		
		if(principal != null) {
	        model.addAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		
		request.setAttribute("tickets",ticketService.ShowAllTickets());
		request.setAttribute("mode", "ALL_TICKET");
		return "support-ticket-admin";
	}
	
	@RequestMapping("/delete-ticket")
	public void deleteTicket(@RequestParam int id,HttpServletRequest request,HttpServletResponse res)throws IOException {
		ticketService.deleteMyTickets(id);
		res.sendRedirect("/show-ticket");
	}
	
	@GetMapping("/open-ticket")
	public String openTicket(@RequestParam int id,HttpServletRequest request,Principal principal) {
		if(principal != null) {
			request.setAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		request.setAttribute("replys",ticketreplyservice.ShowReply());
		request.setAttribute("mode", "OPEN_TICKET");
		return "support-ticket-admin";
	}
	
	@RequestMapping("/edit-status")
	public String editStatus(@RequestParam int id,HttpServletRequest request,@ModelAttribute Ticket ticket1,Principal principal) {
		Ticket ticket =  ticketService.editMyTicket(id);
		ticket.setStatus("Resloved");
		ticket.getStatus();
		ticketService.saveMyTicket(ticket);
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		if(principal != null) {
			request.setAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("replys",ticketreplyservice.ShowReply());
		request.setAttribute("mode","OPEN_TICKET");
		return "support-ticket-admin";
	}
	
	@RequestMapping("/edit-status2")
	public String editStatus2(@RequestParam int id,HttpServletRequest request,@ModelAttribute Ticket ticket1,Principal principal) {
		Ticket ticket =  ticketService.editMyTicket(id);
		ticket.setStatus("Pending");
		ticket.getStatus();
		ticketService.saveMyTicket(ticket);
		request.setAttribute("ticket1", ticketService.editMyTicket(id));
		if(principal != null) {
			request.setAttribute("user", usersService.findByEmail( principal.getName()));
	    }
		request.setAttribute("replys",ticketreplyservice.ShowReply());
		request.setAttribute("mode","OPEN_TICKET");
		return "support-ticket-admin";
	}
	
	
	/*---------------------------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------ReplyTicket----------------------------------------*/
	@PostMapping("/replyTicket")
	public void replyticketuser(@ModelAttribute ReplyTicket reply,BindingResult bindingResult,HttpServletRequest request,HttpServletResponse res)throws IOException  {
		ticketreplyservice.saveReplyTicket(reply);
		res.sendRedirect("/open-Userticket?id= "+reply.getTicket_id());
	}
	
	@PostMapping("/replyTicket1")
	public void replyticket(@ModelAttribute ReplyTicket reply,BindingResult bindingResult,HttpServletRequest request,HttpServletResponse res)throws IOException  {
		ticketreplyservice.saveReplyTicket(reply);
		res.sendRedirect("/open-ticket?id= "+reply.getTicket_id());
	}
	
	
	/*Report generate*/
	
	 @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> citiesReport() {

	        List<Ticket> tickets = (List<Ticket>) ticketService.findAll();

	        ByteArrayInputStream bis = GeneratePdfReport.AllCreatedTicket(tickets);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	
	
}
