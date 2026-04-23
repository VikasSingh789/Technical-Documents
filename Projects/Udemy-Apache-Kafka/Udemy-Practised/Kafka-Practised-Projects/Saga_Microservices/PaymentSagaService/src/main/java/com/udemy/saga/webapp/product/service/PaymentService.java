package com.udemy.saga.webapp.product.service;

import java.util.List;

import com.udemy.saga.webapp.product.dto.Payment;

public interface PaymentService {
	
	List<Payment> findAll();

	Payment process(Payment payment);
}
