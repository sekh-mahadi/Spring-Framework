package io.mtech.spring.app.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mtech.spring.app.service.RandomizerRequestScope;
import io.mtech.spring.app.service.RandomizerSessionScope;

@Controller
public class ScopeController {

	@Autowired
	RandomizerRequestScope randomizerRequestScope;

	@Autowired
	RandomizerSessionScope randomizerSessionScope;

	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception {
		response.getWriter().write("**********************  request scope  ********************** \n");
		response.getWriter().write("Old number: "+ randomizerRequestScope.getRandomNumber() + "\n");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New Number: "+ randomizerRequestScope.getRandomNumber() + "\n");
		response.getWriter().write("Object reference: " + randomizerRequestScope + "\n");

		response.getWriter().write("**********************  session scope  ********************** \n");
		response.getWriter().write("Old number: "+ randomizerSessionScope.getRandomNumber() + "\n");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New Number: "+ randomizerSessionScope.getRandomNumber() + "\n");
		response.getWriter().write("Object reference: " + randomizerSessionScope + "\n");}
}
