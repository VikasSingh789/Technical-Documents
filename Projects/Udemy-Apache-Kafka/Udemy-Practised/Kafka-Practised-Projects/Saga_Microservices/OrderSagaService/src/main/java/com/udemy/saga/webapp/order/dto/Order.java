package com.udemy.saga.webapp.order.dto;



import com.udemy.saga.webapp.order.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
    private Long orderId;
    private Long customerId;
    private Long productId;
    private Integer productQuantity;
    private OrderStatus status;
    
}
