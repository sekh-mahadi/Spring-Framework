package io.mtech.spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mtech.spring_mvc.service.GenericWelcomeService;

@Controller
public class WelcomeController {
	@Autowired
	private GenericWelcomeService welcomeService;

	@RequestMapping("/welcome")
	public String helloworld(Model model) {
		// 1. Retrieving the processed data
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Sekh Mahadi");

		// 2. add data to the madel
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		// 3. return logicla view name
		return "welcomeNew";

	}

}
