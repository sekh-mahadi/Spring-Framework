package io.mtech.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// Create model attribute to the bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		service.saveCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		// Get the Customer from Database
		Customer theCustomer = service.getCustomer(theId);

		// Set Customer as a model attribute
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel) {

		// Get the customer from database
		service.deleteCustomer(theId);

		return "redirect:/customer/list";

	}
}
