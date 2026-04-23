package com.udemy.saga.webapp.product.controller;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;

import com.udemy.saga.webapp.product.command.ReserveProductCommand;
import com.udemy.saga.webapp.product.dto.Product;
import com.udemy.saga.webapp.product.dto.ProductCreationRequest;
import com.udemy.saga.webapp.product.dto.ProductCreationResponse;
import com.udemy.saga.webapp.product.handler.ProductCommandsHandler;
import com.udemy.saga.webapp.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
	@Autowired
	private ProductService productService;
	
	@Autowired
	ProductCommandsHandler productCommandsHandler;

    @PostMapping("/addProducts")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreationResponse save(@RequestBody @Valid ProductCreationRequest request) {
        var product = new Product();
        BeanUtils.copyProperties(request, product);
        Product result = productService.saveProducts(product);

        var productCreationResponse = new ProductCreationResponse();
        BeanUtils.copyProperties(result, productCreationResponse);
        return productCreationResponse;
    }
    
    @GetMapping("/listAllProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        return productService.findAll();
    }
    
    @PostMapping("/productCommand")
    @ResponseStatus(HttpStatus.OK)
    public void productCommandsHandle(@RequestBody ReserveProductCommand command) {
        productCommandsHandler.handleCommand(command);
    }
}
