package com.udemy.saga.webapp.order.service;


import com.udemy.saga.webapp.order.dto.Order;

public interface OrderService {
    Order placeOrder(Order order);
    void approveOrder(Long orderId);
}
