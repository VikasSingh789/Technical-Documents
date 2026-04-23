package com.udemy.saga.webapp.product.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardProcessRequest {

	@NotNull
	private BigInteger creditCardNumber;

	@NotNull
	private BigDecimal paymentAmount;
}
