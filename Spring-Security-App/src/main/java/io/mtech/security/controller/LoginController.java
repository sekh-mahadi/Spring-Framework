package io.mtech.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "loginPage";
		
	}
	
	// add request mapping for / access-denied
	@GetMapping("/access-denied")
	public String accessDenied() {
		
		return "access-denied";
		
	}
}
