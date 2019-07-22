package com.customer.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.domain.CustomerEntity;
import com.customer.rewards.service.CustomerService;

@RestController
@RequestMapping(value= "/customer")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public Long createCustomer(@RequestParam(required = true) String firstName,
			                   @RequestParam(required = true) String lastName,
			                   @RequestParam(required = true)Long phoneNumber,
			                   @RequestParam(required = false)String email) {
		CustomerEntity customerEntity = customerService.createCustomer(firstName, lastName, phoneNumber, email);
		
		return customerEntity.getCustomerId();
		
	}

}
