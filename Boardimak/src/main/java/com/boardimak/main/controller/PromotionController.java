package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boardimak.main.services.PropertyService;
import com.boardimak.main.services.UserService;
import com.boardimak.main.model.Promotion;
import com.boardimak.main.model.Property;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.PromotionServices;



@Controller
public class PromotionController {

	@Autowired
	private PromotionServices promotionService;
	
	@Autowired
	PropertyService pService;
	
	@Autowired
	private UserService usersService;
	
	
	//----------------------------------------Property Owner----------------------------------------------------------------------
	 //show  all promotion page to property owner
	//--------------newly added--------------------
	 @GetMapping("/show-promotion")
	public String showAllPromotion(HttpServletRequest request, Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		request.setAttribute("properties",pService.showAll());
		
		return "promotionhome";
	}
	 
	 
	 @GetMapping("/open-property")
		public String addPropPromotion(@RequestParam int id,HttpServletRequest request) {
			request.setAttribute("property",pService.getAProperty(id));
			request.setAttribute("promotion",promotionService.ShowAllPromotion());
			
			return "addpromotion";
			
       }
	 
	 
		//add promotion and display it
		@PostMapping("/add-promotion")
		public void addPromotion(@ModelAttribute Promotion pro,BindingResult bindingResult,HttpServletRequest request, HttpServletResponse res) throws IOException {
			
			String calPrice = Double.toString((Integer.parseInt(pro.getPro_price()) *(100-Integer.parseInt(pro.getPercentage()))/100.00)) ;
			pro.setNew_price(calPrice);
			promotionService.savePromotion(pro);
			res.sendRedirect("/show-promotion");
		}
	 
	 
	 @GetMapping("/allOwnerPromotion")
		public String showAllOwnersPromotion(HttpServletRequest request, Principal principal, Model model) {
			if (principal != null) {
				model.addAttribute("user", usersService.findByEmail(principal.getName()));
			}
			request.setAttribute("promotion",promotionService.ShowAllPromotion());
			request.setAttribute("properties",pService.showAll());
			
			return "ownerspromotionhome";
		}
	
	
	//delete promotion
	@RequestMapping("/delete-promotion")
	public void deletePromotion(@RequestParam int id,HttpServletRequest request,HttpServletResponse res) throws IOException {
		promotionService.deletePromotion(id);
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		request.setAttribute("properties",pService.showAll());
		
		res.sendRedirect("/show-promotion");
		//return "/show-promotion";
	}

	
	//edit promotion
	@RequestMapping("/edit-promotion")
	public String editPromotion(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("p",promotionService.editPromotion(id));
		//promotionService.deletePromotion(id);
		return "editpromotion";
	}
	
	
	
	//----------------------------------------------controll deactivate----------------------------------------------------------
		@RequestMapping("/DeactivatePromotion")
		public void deactivatePromotion(@RequestParam int id,HttpServletRequest request, HttpServletResponse res) throws IOException{
			Promotion ob = promotionService.getAPromotion(id);
			ob.setStatus("Not Active");
			promotionService.savePromotion(ob);
			res.sendRedirect("/show-promotion");
		}
		
		//------------------------------------------------controll activate--------------------------------------------------------
		@RequestMapping("/ActivatePromotion")
		public void activatePromotion(@RequestParam int id,HttpServletRequest request, HttpServletResponse res) throws IOException {
			Promotion ob = promotionService.getAPromotion(id);
			ob.setStatus("Active");
			promotionService.savePromotion(ob);
			res.sendRedirect("/show-promotion");
		}

	
	//--------------------------------------------------------------Admin----------------------------------------------------
	//show all promotion to admin
	@GetMapping("/admin-promotion")
	public String showAllPromotionAdmin(HttpServletRequest request, Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		
		return "adminpromotion";
	}
	
	//delete promotion
	@RequestMapping("/delete-promotion1")
	public void deletePromotion1(@RequestParam int id,HttpServletRequest request,HttpServletResponse res) throws IOException {
		promotionService.deletePromotion(id);
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		request.setAttribute("properties",pService.showAll());
		
		res.sendRedirect("/admin-promotion");
		//return "/show-promotion";
	}
	
	
	
	//-------------------------------------------------unneccessary---------------------------------------------------------------
	
    //get the page for adding new promotion
	@GetMapping("/new-promotion")
	public String newPromotion(HttpServletRequest request) {
		return "addpromotion";
	}
	
	//real very first promotion page
	@GetMapping("/show-first")
	public String showFrist(HttpServletRequest request) {
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		
		return "firstpromotion";
	}
	
	    //real all promotion page
	@GetMapping("/show-real")
	public String showReal(HttpServletRequest request) {
		request.setAttribute("promotion",promotionService.ShowAllPromotion());
		
		return "realpromotion";
	}
	
	
	
	/*Report generate*/
	//------------------------------------------------------------------------------------------------------------------------------
	//for admin
	 @RequestMapping(value = "/pdfReportAdminPromotion", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> AllAdminPromotionReport() {

	        List<Promotion> promotions = (List<Promotion>) promotionService.ShowAllPromotion();

	        ByteArrayInputStream bis = GeneratePdfReport.AllAdminPromotionReport(promotions);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	//for owners
		 @RequestMapping(value = "/pdfReportOwnerPromotion", method = RequestMethod.GET,
		            produces = MediaType.APPLICATION_PDF_VALUE)
		    public ResponseEntity<InputStreamResource> AllOwnerPromotionReport() {

		        List<Promotion> promotions = (List<Promotion>) promotionService.ShowAllPromotion();

		        ByteArrayInputStream bis = GeneratePdfReport.AllAdminPromotionReport(promotions);

		        //var headers = new HttpHeaders();
		      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		        return ResponseEntity
		                .ok()
		              //  .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
	
		 
			//for one owner
		 @RequestMapping(value = "/oneOwnerPromotion", method = RequestMethod.GET,
		            produces = MediaType.APPLICATION_PDF_VALUE)
		    public ResponseEntity<InputStreamResource> OneOwnerPromotionReport(int user) {

		        List<Promotion> promotions = (List<Promotion>) promotionService.ShowAllPromotionByUser(user);

		        ByteArrayInputStream bis = GeneratePdfReport.OneOwnerPromotionReport(promotions);

		        //var headers = new HttpHeaders();
		      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

		        return ResponseEntity
		                .ok()
		              //  .headers(headers)
		                .contentType(MediaType.APPLICATION_PDF)
		                .body(new InputStreamResource(bis));
		    }
}
