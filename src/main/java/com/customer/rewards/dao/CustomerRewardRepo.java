package com.customer.rewards.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.customer.rewards.domain.CustomerReward;

public interface CustomerRewardRepo extends CrudRepository<CustomerReward, Long> {
	
	public List<CustomerReward> findCustomerRewardsById(Long customerId);

}
