package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.PromotionServices;
import com.boardimak.main.model.Promotion;
import com.boardimak.main.model.Property;
import com.boardimak.main.services.PropertyService;
import com.boardimak.main.services.UserService;

@Controller
public class propertyController {
	
	@Autowired
	PropertyService pService;
	
	@Autowired
	PromotionServices promS;
	
	@Autowired
	private UserService usersService;
    
	//-------------harshani change-----------------
	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		request.setAttribute("promotion",promS.ShowAllPromotion());
		return "index";
	}
	
	//-------------harshani change-----------------
	@GetMapping("/property")
	public String singleProperty(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("property",pService.getAProperty(id));
		request.setAttribute("promotion",promS.ShowAllPromotion());
		return "property";
	}
	
	@GetMapping("/edit-property")
	public String editProperty(Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		return "edit-property";
	}
	
	@GetMapping("/owner")
	public String testingProperty() {
		return "owner-properties";
	}
	
	@GetMapping("/owner/all")
	public String allProperties() {
		return "owner-properties-full";
	}
	
	@GetMapping("/home")
	public String allPropertiesView() {
		return "home-page";
	}
	
	@GetMapping("/admin/property")
	public String showProperties(HttpServletRequest request, Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		request.setAttribute("properties",pService.showAll());
		return "all-properties";
	}
	
	//-------------harshani change-----------------
	@GetMapping("/owner/property")
	public String ownerShowProperties(HttpServletRequest request, Principal principal, Model model) {
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		
		request.setAttribute("properties",pService.showAll());
		request.setAttribute("promotion",promS.ShowAllPromotion());
		return "owner-properties-full";
	}
	
	@PostMapping("/admin/property")
	public String adminSaveObject(@RequestParam("imageFile") MultipartFile file,@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		try {
			pService.saveProperty(newProperty,file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/admin/property";
	}
	
	
	@PostMapping("/owner/property")
	public String saveObject(@RequestParam("imageFile") MultipartFile file,@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		try {
			pService.saveProperty(newProperty,file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/owner/delete-property")
	public String deleteProperty(@RequestParam int id,HttpServletRequest request) {
		pService.deleteProperty(id);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/admin/delete-property")
	public String adminDeleteProperty(@RequestParam int id,HttpServletRequest request) {
		pService.deleteProperty(id);
		return "redirect:/admin/property";
	}
	
	@RequestMapping(value = "/displayImage/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		List<Property> list = pService.showAll();
		
		for(Property property : list) {
			if(property.getId()==id) {
			byte[] ph = property.getData();
			InputStream inputStream = new ByteArrayInputStream(ph);
			IOUtils.copy(inputStream, response.getOutputStream());
			}
		}
		
	}
	

	@RequestMapping("/owner/property/DeactivateProperty")
	public String deactivatePropertyStatus(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Offline");
		System.out.println(ob);
		pService.updateProperty(ob);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/owner/property/ActivateProperty")
	public String activatePropertyStatus(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Active");
		System.out.println(ob);
		pService.updateProperty(ob);
		return "redirect:/owner/property";
	}
	
	@RequestMapping("/admin/property/DeactivateProperty")
	public String deactivateProperty(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Offline");
		System.out.println(ob);
		pService.updateProperty(ob);
		return "redirect:/admin/property";
	}
	
	@RequestMapping("/admin/property/ActivateProperty")
	public String activateProperty(@RequestParam int id,HttpServletRequest request) {
		Property ob = pService.getAProperty(id);
		ob.setStatus("Active");
		System.out.println(ob);
		pService.updateProperty(ob);
		return "redirect:/admin/property";
	}
	
	@PostMapping("/property/update")
	public String updateProperty(@ModelAttribute Property newProperty,BindingResult bindingResult,HttpServletRequest request) {
		pService.updateProperty(newProperty);
		return "redirect:/owner/property";
	}
	
	@GetMapping("/owner/edit-property")
	public String editProperty(@RequestParam int id,HttpServletRequest request, Principal principal, Model model) {
		
		if (principal != null) {
			model.addAttribute("user", usersService.findByEmail(principal.getName()));
		}
		
		request.setAttribute("property",pService.getAProperty(id));
		Property ob = pService.getAProperty(id);
		System.out.println(ob.getCity());
		
		return "edit-property";
	}
/*
	//-------------harshani change-----------------
	@GetMapping("/owner/my-properties")
	public String showPropImages(HttpServletRequest request) {
		request.setAttribute("properties",pService.showAll());
		request.setAttribute("promotion",promS.ShowAllPromotion());
		return "owner-properties-full";
	}
	*/
	
	@GetMapping("/owner/proposal")
	public String showProposals(HttpServletRequest request) {
		request.setAttribute("proposals",pService.showProposals());
		return "proposal-review";
	}
	
	/*
	@RequestMapping("/owner/proposal/accept")
	public String acceptProposals(@RequestParam int id,HttpServletRequest request) {
		Proposal ob = pService.getAProposal(id);
		ob.setStatus("Accepted");
		System.out.println(ob);
		pService.saveProposal(ob);
		return "redirect:/owner/proposal";
	}
	
	@RequestMapping("/owner/proposal/reject")
	public String rejectProposals(@RequestParam int id,HttpServletRequest request) {
		Proposal ob = pService.getAProposal(id);
		ob.setStatus("Rejected");
		System.out.println(ob);
		pService.saveProposal(ob);
		return "redirect:/owner/proposal";
	}*/
	
	@RequestMapping("/owner/proposal/delete")
	public String deleteProposals(@RequestParam int id,HttpServletRequest request) {
		
		pService.deleteProposal(id);
		return "redirect:/owner/proposal";
	}
	
	
	 @RequestMapping(value = "/report/property", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> AllAdminPromotionReport() {

	        List<Property> property = (List<Property>) pService.showAll();

	        //ByteArrayInputStream bis = GeneratePdfReport.AllAdminPromotionReport(promotions);
	        ByteArrayInputStream bis = GeneratePdfReport.AllCreatedProperties(property);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	
}
