package com.customer.rewards.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.service.CustomerRewardService;

@RestController
@RequestMapping(value = "/customerreward")
public class CustomerRewardRestController {
	
	@Autowired
	private CustomerRewardService customerRewardService;
	
	@RequestMapping (value = "/addrewards", method = RequestMethod.POST)
	public String addRewards(@RequestParam(required = true) Long customerId, 
			                 @RequestParam(required = true) BigDecimal purchaseAmount) {
		Long rewards = customerRewardService.addRewards(customerId, purchaseAmount);
		if(rewards != null) {
			return "Added Rewards : " + rewards;
		}else {
			return "No Account exists with the given customerId: " + customerId;
		}
	}
	
	@RequestMapping (value = "/getTotalRewardsByCustomerId", method = RequestMethod.GET)
	public String getTotalRewardsByCustomerId(@RequestParam(required = true) Long customerId) {
		Long totalRewards = customerRewardService.getTotalRewardsByCustomerId(customerId);
		return "Total Rewards for the given Customer: " + customerId + " are " + totalRewards;
	}
	
	@RequestMapping (value = "/getTotalRewardsByCustomerIdAndMonth", method = RequestMethod.GET)
	public String getTotalRewardsByCustomerIdAndMonth(@RequestParam(required = true) Long customerId,
			                                          @RequestParam(required = true) Long month) {
		Long totalRewards = customerRewardService.getTotalRewardsByCustomerIdAndMonth(customerId, month);
		return "Total Rewards for the given Customer: " + customerId + " for the given month " + month + " are " + totalRewards;
	}
}
