package com.boardimak.main.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC; //sl4j
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boardimak.main.services.TicketService;
import com.boardimak.main.services.UserService;
import com.boardimak.main.annotation.RequiresPermission;
import com.boardimak.main.authorization.Authorizable;
import com.boardimak.main.model.Ticket;
import com.boardimak.main.model.User;

//MDC.put("user_ID", usersService.findByEmail( principal.getName()).getId());

@Controller
public class RestController implements Authorizable {

	@Autowired
	private UserService usersService;

	// Register view
	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		request.setAttribute("mode", "USER_VIEW");
		request.setAttribute("users", usersService.findAllUsers());

		return "users";
	}

	// Login view
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "VIEW_LOGIN");
		return "login";
	}

	// Register view
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		request.setAttribute("mode", "VIEW_REGISTER");
		return "login";
	}

	// Reset password view
	@RequestMapping("/reset-password")
	public String resetPassword(HttpServletRequest request) {
		request.setAttribute("mode", "VIEW_RESET_PASSWORD");
		return "login";
	}
	
	//Dashboard 
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		return "dashboard";
	}
		
	// View users
	@RequestMapping("/users")
	@RequiresPermission(permission = "USERS")
	public String users(HttpServletRequest request, Model model, Principal principal) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		
		request.setAttribute("mode", "USER_VIEW");
		request.setAttribute("users", usersService.findAllUsers());
		System.out.println("I am admin");
		return "users";
	}

	// Edit user
	@RequestMapping("/editUser")
	public String editUser(@RequestParam int id, HttpServletRequest request, Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}

		request.setAttribute("user", usersService.findOne(id));

		request.setAttribute("mode", "USER_EDIT");
		return "users";
	}

	// Save user
	@PostMapping("/saveUser")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		usersService.saveUser(user);
		request.setAttribute("users", usersService.findAllUsers());
		request.setAttribute("mode", "USER_VIEW");
		return "redirect:/users";
	}
	
	// Register account
	@PostMapping("/registerAccount")
	public String resiterAccount(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		usersService.saveUser(user);
		request.setAttribute("users", usersService.findAllUsers());
		request.setAttribute("mode", "USER_VIEW");
		if (user.getUserType().equals("Student") || user.getUserType().equals("Parent")) {
			return "redirect:/register-payment";
		} else if (user.getUserType().equals("Owner")) {
			return "redirect:/register-owner";

		}
		return "redirect:/users";
	}

	// Delete user
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		usersService.deleteUser(id);
		request.setAttribute("users", usersService.findAllUsers());
		request.setAttribute("mode", "USER_VIEW");
		return "redirect:/users";
	}
}
