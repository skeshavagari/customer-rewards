package com.customer.rewards.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class CustomerEntity {
	
	@Id
	@GeneratedValue
	private Long customerId;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "customerEntity")
	private List<CustomerReward> customerRewards;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomerReward> getCustomerRewards() {
		return customerRewards;
	}

	public void setCustomerRewards(List<CustomerReward> customerRewards) {
		this.customerRewards = customerRewards;
	}
	
}
