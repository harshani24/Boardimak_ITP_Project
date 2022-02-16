package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boardimak.main.model.Payments;
import com.boardimak.main.model.Property;
import com.boardimak.main.model.Users;
import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.PaymentService;
import com.boardimak.main.services.StripeService;
import com.boardimak.main.services.UserService;
import com.boardimak.main.services.UsersService;
import com.google.gson.JsonObject;
import com.stripe.exception.StripeException;

@Controller
public class PaymentsController {

	@Autowired
	private PaymentService paymentservice;
	
	@Autowired StripeService stripeservice;

	@Autowired
	UsersService usersservice;
	
	@Autowired
	private UserService usersService;
	
	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;
	
	
//	@GetMapping("/payment/details")
//	public void paymentDetails() {
//		paymentservice.createPayment(p);
//		System.out.println(p.getAmount());
//	}
	
	@PostMapping("/pay-owner")
	public @ResponseBody String payment(int propertyId, String password, Principal principal) throws StripeException {

		Users user = usersservice.getIdByEmail(principal.getName());
		
		String payResult = paymentservice.paymentHelper(propertyId, user, password);
		
		JsonObject result = new JsonObject();
		if (payResult.equals("password was incorrect")) {
			result.addProperty("isWorking", "wrongPass");
		} else if(payResult.equals("no property")){
			result.addProperty("isWorking", "noProperty");
		}else {
			result.addProperty("isWorking", "working");
		}
		return result.toString();
	}
	
	@GetMapping("/payment-details")
	public String showProperties(HttpServletRequest request, Principal principal, Model model) {
		System.out.println(principal.getName());
		
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		
		Users user = usersservice.getIdByEmail(principal.getName());
		if(!(user.getStripeId() == null)) {
			request.setAttribute("payments",paymentservice.allByStripeId(user.getStripeId()));
		}else if(!(user.getAccountId() == null)) {
			request.setAttribute("payments",paymentservice.allByAccountId(user.getAccountId()));
		}
		return "payment-details";
	}
	
	@GetMapping("/all-payments")
	public String allpayments(HttpServletRequest request, Principal principal, Model model){
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		request.setAttribute("payments",paymentservice.showAll());
		return "all-payments";
	}
	
	/*Report generate*/
	
	 @RequestMapping(value = "/paymentReport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> citiesReport() {

	        List<Payments> payments = paymentservice.showAll();

	        ByteArrayInputStream bis = GeneratePdfReport.allPaymentsReport(payments);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 @RequestMapping(value = "paymentInvoice", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> invoice(@RequestParam int id,HttpServletRequest request) throws StripeException {

		 Payments payment = paymentservice.showById(id);
		 Users customer = usersservice.getUserByStripe(payment.getStripe_id());
		 Users owner = usersservice.getUserByAccount(payment.getAccount_id());

	        ByteArrayInputStream bis = GeneratePdfReport.paymentInvoice(payment, customer, owner);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
}
