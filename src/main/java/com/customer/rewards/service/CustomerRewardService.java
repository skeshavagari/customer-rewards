package com.customer.rewards.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.dao.CustomerRepo;
import com.customer.rewards.dao.CustomerRewardRepo;
import com.customer.rewards.domain.CustomerEntity;
import com.customer.rewards.domain.CustomerReward;

@Service
public class CustomerRewardService {
	
	@Autowired
	private CustomerRewardRepo customerRewardRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Long addRewards (Long customerId, BigDecimal purchaseAmount) {
		
		Optional<CustomerEntity> customerEntity = customerRepo.findById(customerId);
		if (customerEntity.isPresent()) {
			
			CustomerReward customerReward = new CustomerReward();
			customerReward.setCustomerEntity(customerEntity.get());
			customerReward.setPurchaseAmount(purchaseAmount);
			customerReward.setPurchaseDate(new Date());
			Long rewards = calculateRewards(purchaseAmount);
			customerReward.setRewards(rewards);
			customerRewardRepo.save(customerReward);
			
			return rewards;
		}
		return null;
	}
	
	
	private Long calculateRewards(BigDecimal purchaseAmount) {
		Long amount = purchaseAmount.longValue();
		if(amount <= 50) {
			return 0l;
		} else if (amount > 50 && amount <= 100) {
			return (amount - 50l);
		}else {
			return (50 + ((amount - 100)*2));
		}
	}
	
	public Long getTotalRewardsByCustomerId(Long customerId) {
		List<CustomerReward> customerRewardList = customerRewardRepo.findCustomerRewardsById(customerId);
		Long totalRewards = 0L;
		for (CustomerReward customerReward : customerRewardList) {
			totalRewards = Long.sum(totalRewards, customerReward.getRewards());
		}
		return totalRewards;
		
	}
	
	public Long getTotalRewardsByCustomerIdAndMonth(Long customerId, Long month) {
		List<CustomerReward> customerRewardList = customerRewardRepo.findCustomerRewardsById(customerId);
		List<CustomerReward> customerRewardListForMonth = customerRewardList.stream()
		.filter( (customerReward) -> month.equals(Long.valueOf(customerReward.getPurchaseDate().getMonth() + 1)))
		.collect(Collectors.toList());
		Long totalRewards = 0L;
		for (CustomerReward customerReward : customerRewardListForMonth) {
			totalRewards = Long.sum(totalRewards, customerReward.getRewards());
		}
		return totalRewards;
	}

}
