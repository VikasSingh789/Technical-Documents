package com.udemy.saga.webapp.product.service;

import java.util.List;

import com.udemy.saga.webapp.product.dto.Product;

public interface ProductService {

	List<Product> findAll();

	Product reserve(Product desiredProduct, Long orderId);

	void cancelReservation(Product productToCancel, Long orderId);

	Product saveProducts(Product product);
}
