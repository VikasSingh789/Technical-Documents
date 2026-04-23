package com.udemy.saga.webapp.order.entity;

import com.udemy.saga.webapp.order.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "status")
	private OrderStatus status;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_quantity")
	private Integer productQuantity;
}
