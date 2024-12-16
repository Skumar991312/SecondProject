package in.skumar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashboard() {
		
		return "dashboard";
	}
	
	@GetMapping("/enquiry")
	public String addEnquiryPage() {
		
		return "add-enquiry";
		
	}
	
	@GetMapping("/enquries")
	public String viewEnquiryPage() {
		
		return "add-enquiry";
	}

}
