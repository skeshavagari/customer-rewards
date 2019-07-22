package com.customer.rewards.dao;

import org.springframework.data.repository.CrudRepository;

import com.customer.rewards.domain.CustomerEntity;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
	
}
