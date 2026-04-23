package com.udemy.saga.webapp.product.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreationRequest {

	@NotBlank
	private String name;

	@NotNull
	@Positive
	private BigDecimal price;

	@Positive
	private Integer quantity;
}
