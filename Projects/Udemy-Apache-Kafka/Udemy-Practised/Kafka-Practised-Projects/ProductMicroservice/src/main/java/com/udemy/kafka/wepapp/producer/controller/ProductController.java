package com.udemy.kafka.wepapp.producer.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.kafka.wepapp.producer.dto.CreateProductRestModel;
import com.udemy.kafka.wepapp.producer.dto.ErrorMessage;
import com.udemy.kafka.wepapp.producer.service.impl.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	
	@Autowired
	ProductServiceImpl productService;
	
	@PostMapping("publish-Asynchronous")
	public ResponseEntity<Object> createProductAsync(@RequestBody CreateProductRestModel product) {
		log.info("In ProductController::createProduct()");
		log.info("Request Body Object:{}",product);
		
		String productId;
		try { 
			productId = productService.createProductAsync(product);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(new Date(), e.getMessage(),"/products"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
	}
	
	@PostMapping("publish-Synchronous")
	public ResponseEntity<Object> createProductSync(@RequestBody CreateProductRestModel product) {
		log.info("In ProductController::createProductSync()");
		log.info("Request Body Object:{}",product);
		
		String productId;
		try {
			productId = productService.createProductSync(product);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ErrorMessage(new Date(), e.getMessage(),"/products"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(productId);
	}

}
