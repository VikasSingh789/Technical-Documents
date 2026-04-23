package com.wipro.jcb.livelink.app.machines.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.jcb.livelink.app.commonUtils.repo.CustomerRepository;

@RestController
public class MachineController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping
	public String getCustomer() {
		return customerRepository.findCustomerNameById(1);
	}
}