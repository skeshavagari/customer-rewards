package com.customer.rewards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.dao.CustomerRepo;
import com.customer.rewards.domain.CustomerEntity;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public CustomerEntity createCustomer(String firstName, String lastName, Long phoneNumber, String email) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		
		customerEntity.setFirstName(firstName);
		customerEntity.setLastName(lastName);
		customerEntity.setPhoneNumber(phoneNumber);
		customerEntity.setEmail(email);
		return customerRepo.save(customerEntity);

	}
	
	
	
}
