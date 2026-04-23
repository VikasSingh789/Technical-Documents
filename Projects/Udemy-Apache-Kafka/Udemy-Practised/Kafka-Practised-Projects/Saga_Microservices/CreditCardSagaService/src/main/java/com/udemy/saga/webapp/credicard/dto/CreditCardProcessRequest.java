package com.udemy.saga.webapp.credicard.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardProcessRequest {
    
	@Nonnull
    private BigInteger creditCardNumber;
    
	@Nonnull
    private BigDecimal paymentAmount;

    
}
