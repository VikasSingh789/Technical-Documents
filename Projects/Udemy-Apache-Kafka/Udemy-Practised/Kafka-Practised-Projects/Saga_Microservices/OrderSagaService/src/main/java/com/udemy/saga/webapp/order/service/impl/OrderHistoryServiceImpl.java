package com.udemy.saga.webapp.order.service.impl;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.saga.webapp.order.dto.OrderHistory;
import com.udemy.saga.webapp.order.entity.OrderHistoryEntity;
import com.udemy.saga.webapp.order.enums.OrderStatus;
import com.udemy.saga.webapp.order.repo.OrderHistoryRepository;
import com.udemy.saga.webapp.order.service.OrderHistoryService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderHistoryServiceImpl implements OrderHistoryService {
	
	@Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public void add(Long orderId, OrderStatus orderStatus) {
    	log.info("In OrderHistoryServiceImpl::add()");
    	log.info("Order ID:{} With Order Status:{}",orderId,orderStatus);
        OrderHistoryEntity entity = new OrderHistoryEntity();
        entity.setOrderId(orderId);
        entity.setStatus(orderStatus);
        entity.setCreatedAt(LocalDateTime.now());
        orderHistoryRepository.save(entity);
        log.info("Order History Data Saved in orders_history table:{}",entity);
    }

    @Override
    public List<OrderHistory> findByOrderId(Long orderId) {
    	log.info("In OrderHistoryServiceImpl::findByOrderId()");
    	log.info("Order ID:{}",orderId);
        var entities = orderHistoryRepository.findByOrderId(orderId);
        return entities.stream().map(entity -> {
            OrderHistory orderHistory = new OrderHistory();
            BeanUtils.copyProperties(entity, orderHistory);
            return orderHistory;
        }).toList();
    }
}
