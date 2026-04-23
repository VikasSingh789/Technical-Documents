package com.udemy.saga.webapp.order.service;


import java.util.List;

import com.udemy.saga.webapp.order.dto.OrderHistory;
import com.udemy.saga.webapp.order.enums.OrderStatus;

public interface OrderHistoryService {
    void add(Long orderId, OrderStatus orderStatus);

    List<OrderHistory> findByOrderId(Long orderId);
}
