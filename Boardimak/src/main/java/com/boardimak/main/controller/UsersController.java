package com.boardimak.main.controller;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boardimak.main.model.Proposal;
import com.boardimak.main.model.Users;
import com.boardimak.main.services.StripeService;
import com.boardimak.main.services.UserService;
import com.boardimak.main.services.UsersService;
import com.google.gson.JsonObject;
import com.stripe.exception.StripeException;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersservice;

	@Autowired
	private StripeService stripeservice;
	
	@Autowired UserService usersService;

	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;

	@GetMapping("/register-payment")
	public String registerPay() {
		return "register-payment";
	}

	// create stripe customer
	@PostMapping("/createCust")
	public @ResponseBody String createCust(String token, String email) {

		JsonObject result = new JsonObject();
		String customerId = stripeservice.createCustomer(token, email);
		if (customerId.equals("Wrong Email")) {
			result.addProperty("isWorking", "wrongEmail");
		} else if (customerId.equals("Alread Have An Account")) {
			result.addProperty("isWorking", "hasAccount");
		} else {
			result.addProperty("isWorking", "done");
		}
		return result.toString();
	} // The rest controller for creating a customer stripe account 

	/* Proposal requests */
	@PostMapping("/submit-proposal")
	public @ResponseBody String submitMessage(int propertyId, String mHead, String mBody, Principal principal) {
		Users user = usersservice.getIdByEmail(principal.getName());
		Proposal proposal = new Proposal(mHead, mBody, propertyId, user.getId());
		usersservice.saveProposal(proposal);
		
		JsonObject result = new JsonObject();
		result.addProperty("isWorking", "done");
		return result.toString();
	} // controller to catch a proposal from the front end

	// Method to view all proposals
	@RequestMapping("/view/Proposals")
	public String viewProposals( Principal principal, HttpServletRequest request, Model model) {
		Users user = usersservice.getIdByEmail(principal.getName());
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		ArrayList<Proposal> proposals = new ArrayList<>();
		for (Proposal p : usersservice.findProposals()) {
			if (p.getUser_id() == user.getId()) {
				proposals.add(p);
			}
		}
		request.setAttribute("proposals", proposals);
		return "view-proposals";
	}

	// Method to delete a proposal
	@RequestMapping("/delete/proposal")
	public String deleteProposal(@RequestParam int id, @RequestParam int userId, HttpServletRequest request) {
		usersservice.deleteProposal(id);
		return "redirect:/view/Proposals?id=" + userId;
	}

	/* Create account requests */
	@GetMapping("/register-owner")
	public String index() {
		return "custom-account";
	} // get method to get the register owner page
	
	@PostMapping("/create/owner")
	public String createOwner(@ModelAttribute Users newOwner, BindingResult bindingResult,HttpServletRequest request) {
		System.out.println(newOwner.getEmail());
		usersservice.saveOwner(newOwner);
		return "owner-properties";
	}
	
	// Rest controller to create a custom account in stripe 
	@PostMapping("/create-account")
    public @ResponseBody
    String createAccount(String token, String email) throws StripeException {
		JsonObject result = new JsonObject();
		
		System.out.println("create account called");

        String s = stripeservice.createAccount(token, email);
        if(s.equals("wrong email")) {
        	result.addProperty("isWorking", "wrongEmail");
        }else if(s.equals("already has an account")) {
        	result.addProperty("isWorking", "hasAccount");
        }else {
        	result.addProperty("isWorking", "done");
        }
        
        return result.toString();
	}
}
