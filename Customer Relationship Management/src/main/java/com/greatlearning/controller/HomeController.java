package com.greatlearning.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.model.Customer;
import com.greatlearning.service.CustomerServiceImpl;

@Controller
public class HomeController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@RequestMapping("/customerlist")
	public String showAllCustomers(Model model) {

		List<Customer> customers = customerServiceImpl.getAllCustomer();

		model.addAttribute("customers", customers);

		return "index";

	}

	@RequestMapping("/addcustomer")
	public String showaddform() {

		return "addcustomer";

	}

	@RequestMapping("/editcustomer")
	public String showeditform(@RequestParam("id") long id, Model model) {

		Customer customer = customerServiceImpl.getCustomerById(id);

		model.addAttribute("customer", customer);

		return "updatecustomer";

	}

	@RequestMapping("/deletecustomer")
	public String deletecustomer(@RequestParam("id") long id) {

		customerServiceImpl.deleteCustomer(id);

		return "redirect:/customerlist";

	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute Customer customer) {

		if (customer.getId() != 0) {
			Customer newCustomer = customerServiceImpl.getCustomerById(customer.getId());

			newCustomer.setFirstName(customer.getFirstName());

			newCustomer.setLastName(customer.getLastName());

			newCustomer.setEmail(customer.getEmail());

			customer = newCustomer;

		}

		customerServiceImpl.addCustomer(customer);

		return "redirect:/customerlist";

	}

}
