package com.boardimak.main.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boardimak.main.model.Blogs;
import com.boardimak.main.model.CmsOther;
import com.boardimak.main.model.Payments;
import com.boardimak.main.services.CmsOtherServices;
import com.boardimak.main.services.CmsService;
import com.boardimak.main.services.GeneratePdfReport;
import com.boardimak.main.services.UserService;



@Controller
public class CmsController {

	@Autowired
	private CmsService blogService;
	
	@Autowired
	private UserService usersService;

	@Autowired
	private CmsOtherServices cmsOtherService;

	@GetMapping("/cmsHome")
	public String Welcome1(HttpServletRequest request) {
		request.setAttribute("blogs", blogService.findAllBlogs());
		request.setAttribute("others", cmsOtherService.findAllOthers());
		return "cmshome";
	}

	@GetMapping("/savedOk")
	public String SavedOk(HttpServletRequest request) {
		request.setAttribute("blogs", blogService.findAllBlogs());
		return "cmshome";
	}

	@GetMapping("/delete-blog")
	public void deleteBlog(@RequestParam int id, HttpServletRequest request, HttpServletResponse res) throws IOException {
		blogService.deleteBlogs(id);
		res.sendRedirect("/cmsHome");
		
	}

	@GetMapping("/newBlog")
	public String newBlog(HttpServletRequest request, Principal principal) {
//		if(principal != null) {
//	       
//	        request.setAttribute("blogss", usersService.findByEmail( principal.getName()));
//	    }
		return "new_blog";
	}

	@PostMapping("/saveBlog")
	public void saveBlog(@RequestParam("imageFile") MultipartFile file,@ModelAttribute Blogs blogs, HttpServletRequest request, HttpServletResponse res, Principal principal)
			throws Exception {
		
		String a = ((usersService.findByEmail( principal.getName())).getFirstName() ) + " " + (usersService.findByEmail( principal.getName()) ).getLastName();
		blogs.setAuthor(a);
		
		String fileName = file.getOriginalFilename();
    	System.out.println(fileName);
        try {
           
            blogs.setData(file.getBytes());
            blogService.saveBlog(blogs);
            
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
        
		
		blogService.saveBlog(blogs);
		res.sendRedirect("/cmsHome");
	}
	
	@RequestMapping(value = "/displayImageBlog/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		List<Blogs> list = blogService.findAllBlogs();
		
		for(Blogs blog : list) {
			if(blog.getId()==id) {
			byte[] ph = blog.getData();
			InputStream inputStream = new ByteArrayInputStream(ph);
			IOUtils.copy(inputStream, response.getOutputStream());
			}
		}
		
	}

	@GetMapping("/editBlog")
	public String editBlog(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("blogs", blogService.findOneBlog(id));
		
		return "edit_blog";
	}
	
	@GetMapping("/viewAll-Blogs")
	public String viewAllblogs( HttpServletRequest request) {
		request.setAttribute("blogs", blogService.findAllBlogs());
		
		return "allBlogsView";
	}

	@GetMapping("/newPolicy")
	public String CmsPrivacy(HttpServletRequest request) {
		
		CmsOther oth = new CmsOther(0);
		request.setAttribute("other", oth);
		request.setAttribute("others", cmsOtherService.findAllOthers());
		return "cms_privacy_policy";
	}

	@PostMapping("/savePrivacyPolicy")
	public void savePrivacyPolicy(@ModelAttribute CmsOther other, HttpServletRequest request, HttpServletResponse res, Principal principal)
			throws IOException {

		String a = ((usersService.findByEmail( principal.getName())).getFirstName() ) + " " + (usersService.findByEmail( principal.getName()) ).getLastName();
		other.setAuthor(a);
		cmsOtherService.saveCmsOther(other);
		res.sendRedirect("/newPolicy");

	}

	@GetMapping("/newTerm")
	public String CmsTerms(HttpServletRequest request) {
		request.setAttribute("others", cmsOtherService.findAllOthers());
		
		CmsOther oth = new CmsOther(0);
		request.setAttribute("other", oth);
		return "cms_terms";
	}

	@PostMapping("/saveTerm")
	public void saveTerms(@ModelAttribute CmsOther other, HttpServletRequest request, HttpServletResponse res, Principal principal)
			throws IOException {

		String a = ((usersService.findByEmail( principal.getName())).getFirstName() ) + " " + (usersService.findByEmail( principal.getName()) ).getLastName();
		other.setAuthor(a);
		cmsOtherService.saveCmsOther(other);
		res.sendRedirect("/newTerm");

	}

	@GetMapping("/newFAQ")
	public String CmsFA(HttpServletRequest request) {
		
		CmsOther oth = new CmsOther(0);
		request.setAttribute("other", oth);
		request.setAttribute("others", cmsOtherService.findAllOthers());
		return "cms_faq";
	}

	@PostMapping("/saveFA")
	public void saveFAs(@ModelAttribute CmsOther other, HttpServletRequest request, HttpServletResponse res, Principal principal)
			throws IOException {

		String a = ((usersService.findByEmail( principal.getName())).getFirstName() ) + " " + (usersService.findByEmail( principal.getName()) ).getLastName();
		other.setAuthor(a);
		cmsOtherService.saveCmsOther(other);
		res.sendRedirect("/newFAQ");

	}

	@GetMapping("/delete-cmsothers")
	public void deleteCmsothers(@RequestParam int id, HttpServletRequest request, HttpServletResponse res) throws IOException {
		cmsOtherService.deleteOthers(id);
		res.sendRedirect("/cmsHome");
	}

	@GetMapping("/editcmsothers")
	public String editcmsOther(@RequestParam int id, HttpServletRequest request) {
		
		CmsOther oth = cmsOtherService.findOneOthers(id);
		
		String type = oth.getType();
		String page = null ;
		String typeFA = "FA";
		String typePo = "Policy";
		String typeTC = "TC";
		
		if(type.equals(typeFA)) {
			request.setAttribute("other", oth);
			request.setAttribute("others", cmsOtherService.findAllOthers());
//			cmsOtherService.deleteOthers(id);
			return "cms_faq";
		}else if(type.equals(typePo)){
			request.setAttribute("other", oth);
			request.setAttribute("others", cmsOtherService.findAllOthers());
//			cmsOtherService.deleteOthers(id);
			return "cms_privacy_policy";
		}else if(type.equals(typeTC)) {
			request.setAttribute("other", oth);
			request.setAttribute("others", cmsOtherService.findAllOthers());
//			cmsOtherService.deleteOthers(id);
			return "cms_terms";
		}else {
			request.setAttribute("blogs", blogService.findAllBlogs());
			request.setAttribute("others", cmsOtherService.findAllOthers());
			return "cmshome";
		}
		
		
		

	}
	
	
	
	 @RequestMapping(value = "/blogReport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> blogReport() {

	        List<Blogs> blog = blogService.findAllBlogs();

	        ByteArrayInputStream bis = GeneratePdfReport.allBlogsReport(blog);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
	 
	 @RequestMapping(value = "/cmsOtherReport", method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_PDF_VALUE)
	    public ResponseEntity<InputStreamResource> citiesReport() {

	        List<CmsOther> CmsOther = cmsOtherService.findAllOthers();

	        ByteArrayInputStream bis = GeneratePdfReport.allCMSOtherReport(CmsOther);

	        //var headers = new HttpHeaders();
	      //  headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

	        return ResponseEntity
	                .ok()
	              //  .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(bis));
	    }
}
