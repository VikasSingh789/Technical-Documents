package com.udemy.kafka.wepapp.producer.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRestModel {

	private String title;
	private BigDecimal price;
	private Integer quantity;

}
