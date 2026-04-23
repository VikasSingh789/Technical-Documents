package com.saga.webapp.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saga.webapp.stock.dto.DeliveryEvent;
import com.saga.webapp.stock.dto.OrderRequest;
import com.saga.webapp.stock.dto.PaymentEvent;
import com.saga.webapp.stock.dto.StockRequest;
import com.saga.webapp.stock.entity.Stock;
import com.saga.webapp.stock.repo.StockRepository;

@RestController
@RequestMapping("/api")
public class StockController {

	@Autowired
	private StockRepository repository;

	@Autowired
	private KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, PaymentEvent> kafkaPaymentTemplate;

	@KafkaListener(topics = "new-payments", groupId = "payments-group")
	public void updateStock(String paymentEvent) throws JsonMappingException, JsonProcessingException {
		System.out.println("Inside update inventory for order " + paymentEvent);

		DeliveryEvent event = new DeliveryEvent();

		PaymentEvent p = new ObjectMapper().readValue(paymentEvent, PaymentEvent.class);
		OrderRequest order = p.getOrderRequest();

		try {
			Stock inventories = repository.findByItem(order.getItem());

			if (ObjectUtils.isEmpty(inventories)) {
				System.out.println("Stock not exist so reverting the order");
				throw new Exception("Stock not available");
			}

			if (inventories.getQuantity() < order.getQuantity()) {
				System.out.println("Requested Order is Out of Stock");
				throw new Exception("Stock not available");
			}

			inventories.setQuantity(inventories.getQuantity() - order.getQuantity());
			repository.save(inventories);

			event.setType("STOCK_UPDATED");
			event.setOrder(p.getOrderRequest());
			kafkaTemplate.send("new-stock", event);
		} catch (Exception e) {
			PaymentEvent pe = new PaymentEvent();
			pe.setOrderRequest(order);
			pe.setType("PAYMENT_REVERSED");
			kafkaPaymentTemplate.send("reversed-payments", pe);
		}
	}

	@PostMapping("/addItems")
	public void addItems(@RequestBody StockRequest stockRequest) {
		Stock items = repository.findByItem(stockRequest.getItem());

		if (!ObjectUtils.isEmpty(items)) {
			items.setQuantity(stockRequest.getQuantity() + items.getQuantity());
			repository.save(items);
		} else {
			Stock i = new Stock();
			i.setItem(stockRequest.getItem());
			i.setQuantity(stockRequest.getQuantity());
			repository.save(i);
		}
	}
}