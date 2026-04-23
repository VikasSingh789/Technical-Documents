package com.udemy.saga.webapp.order.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.udemy.saga.webapp.order.dto.Order;
import com.udemy.saga.webapp.order.entity.OrderEntity;
import com.udemy.saga.webapp.order.enums.OrderStatus;
import com.udemy.saga.webapp.order.events.OrderApprovedEvent;
import com.udemy.saga.webapp.order.events.OrderCreatedEvent;
import com.udemy.saga.webapp.order.repo.OrderRepository;
import com.udemy.saga.webapp.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	
	@Value("${orders.events.topic.name}")
	String ordersEventsTopicName;
	
	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
    @Override
    public Order placeOrder(Order order) {
    	log.info("In OrderServiceImpl::placeOrder()");
    	log.info("Order Placed Data:{}",order);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerId(order.getCustomerId());
        orderEntity.setProductId(order.getProductId());
        orderEntity.setProductQuantity(order.getProductQuantity());
        orderEntity.setStatus(OrderStatus.CREATED);
        orderRepository.save(orderEntity);
        log.info("Order Data Saved in orders Table:{}",orderEntity);

        OrderCreatedEvent placedOrder = new OrderCreatedEvent(
        		orderEntity.getId(),
        		orderEntity.getCustomerId(),
                order.getProductId(),
                order.getProductQuantity()
        );
        kafkaTemplate.send(ordersEventsTopicName, placedOrder);
        log.info("Order Data Sent on Kafka Topic:{} With Data:{}", ordersEventsTopicName, placedOrder);

        return new Order(
        		orderEntity.getId(),
        		orderEntity.getCustomerId(),
        		orderEntity.getProductId(),
        		orderEntity.getProductQuantity(),
        		orderEntity.getStatus());
    }

    @Override
    public void approveOrder(Long orderId) {
    	log.info("In OrderServiceImpl::approveOrder()");
    	log.info("Order Id:{}",orderId);
        OrderEntity orderEntity = orderRepository.findById(orderId).orElse(null);
        Assert.notNull(orderEntity, "No order is found with id " + orderId + " in the database table");
        orderEntity.setStatus(OrderStatus.APPROVED);
        orderRepository.save(orderEntity);
        log.info("Order Data Saved in orders Table:{}",orderEntity);
        OrderApprovedEvent orderApprovedEvent = new OrderApprovedEvent(orderId);
        kafkaTemplate.send(ordersEventsTopicName, orderApprovedEvent);
        log.info("Order Approved Data Sent on Kafka Topic:{} With Data:{}",ordersEventsTopicName, orderApprovedEvent);
    }

}
