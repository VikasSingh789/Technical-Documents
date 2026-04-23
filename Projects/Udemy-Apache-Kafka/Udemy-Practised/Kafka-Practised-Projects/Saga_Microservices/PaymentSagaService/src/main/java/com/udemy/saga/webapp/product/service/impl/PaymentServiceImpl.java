package com.udemy.saga.webapp.product.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.saga.webapp.product.dto.Payment;
import com.udemy.saga.webapp.product.entity.PaymentEntity;
import com.udemy.saga.webapp.product.repo.PaymentRepository;
import com.udemy.saga.webapp.product.service.CreditCardProcessorRemoteService;
import com.udemy.saga.webapp.product.service.PaymentService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
	
    public static final String SAMPLE_CREDIT_CARD_NUMBER = "374245455400126";
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private CreditCardProcessorRemoteService ccpRemoteService;

    public Payment process(Payment payment) {
        BigDecimal totalPrice = payment.getProductPrice()
                .multiply(new BigDecimal(payment.getProductQuantity()));
        ccpRemoteService.process(new BigInteger(SAMPLE_CREDIT_CARD_NUMBER), totalPrice);
        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(payment, paymentEntity);
        paymentRepository.save(paymentEntity);

        var processedPayment = new Payment();
        BeanUtils.copyProperties(payment, processedPayment);
        processedPayment.setId(paymentEntity.getId());
        return processedPayment;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll().stream().map(entity -> new Payment(entity.getId(), entity.getOrderId(), entity.getProductId(), entity.getProductPrice(), entity.getProductQuantity())
        ).collect(Collectors.toList());
    }
}
