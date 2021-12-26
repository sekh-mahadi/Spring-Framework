package io.mtech.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String ShowHome() {
		return "home";
	}

	// Add request for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String showAdmins() {
		return "systems";
	}
}
