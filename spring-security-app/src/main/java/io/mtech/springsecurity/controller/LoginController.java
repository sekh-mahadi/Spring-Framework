package io.mtech.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@GetMapping("/loginPage")
	public String loginPage() {
		return "plain-login";
	}

	// Bootstrap CSS Login
	// @GetMapping("/fancyLogin")

	@RequestMapping(value = "/fancyLogin", method = RequestMethod.GET)
	public String loginUsingBootstrap() {
		return "fancyLogin";
	}

}
