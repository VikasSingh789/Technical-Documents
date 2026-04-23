package com.saga.webapp.payments.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saga.webapp.payments.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	public List<Payment> findByOrderId(long orderId);

}
