package io.mtech.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.mtech.springmvc.entity.Customer;
import io.mtech.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject the customer Service
	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String listCustomer(Model model) {

		// Get the customer from the DAO/Service
		List<Customer> theCustomers = service.getCustomers();

		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
