package in.skumar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ch.qos.logback.core.model.Model;
import in.skumar.bindig.SignUpForm;
import in.skumar.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String handlesSignUp(SignUpForm form, ModelMap model) {
		
		boolean status=userService.signup(form);
		
		if(status) {
			model.addAttribute("success","check Your Email");
		}
		else {
			model.addAttribute("ErrorMsg","problem occurs");
		}
			
			return "signup";
		}
		
	
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}


	 @GetMapping("/signup") 
	public String signUpPage(ModelMap model) {
		model.addAttribute("user", new SignUpForm());
		return "signup"; 
	}
	 
	@GetMapping("/unlock")
    public String unlockPage() {
		 
	return "unlock"; 
}
	 
	 @GetMapping("/forgot")
	 public String forgotPwdPage() {
		 
		 return "forgotPwd";
	 }
}

