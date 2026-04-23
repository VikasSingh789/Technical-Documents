package com.udemy.saga.webapp.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.saga.webapp.product.dto.Product;
import com.udemy.saga.webapp.product.entity.ProductEntity;
import com.udemy.saga.webapp.product.exception.ProductInsufficientQuantityException;
import com.udemy.saga.webapp.product.repo.ProductRepository;
import com.udemy.saga.webapp.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	private ProductRepository productRepository;

    @Override
    public Product reserve(Product desiredProduct, Long orderId) {
    	log.info("In ProductServiceImpl::reserve()");
    	log.info("Desired Product:{} OrderId:{}",desiredProduct,orderId);
        ProductEntity productEntity = productRepository.findById(desiredProduct.getId()).orElseThrow();
        if (desiredProduct.getQuantity() > productEntity.getQuantity()) {
            throw new ProductInsufficientQuantityException(productEntity.getId(), orderId);
        }

        productEntity.setQuantity(productEntity.getQuantity() - desiredProduct.getQuantity());
        productRepository.save(productEntity);
        log.info("Product Data Saved in products Table:{}",productEntity);

        var reservedProduct = new Product();
        BeanUtils.copyProperties(productEntity, reservedProduct);
        reservedProduct.setQuantity(desiredProduct.getQuantity());
        return reservedProduct;
    }

    @Override
    public void cancelReservation(Product productToCancel, Long orderId) {
    	log.info("In ProductServiceImpl::cancelReservation()");
    	log.info("Product To Cancel:{}  with OrderId:{}",productToCancel,orderId);
        ProductEntity productEntity = productRepository.findById(productToCancel.getId()).orElseThrow();
        productEntity.setQuantity(productEntity.getQuantity() + productToCancel.getQuantity());
        productRepository.save(productEntity);
        log.info("Product Data Saved in products Table:{}",productEntity);
    }

    @Override
    public Product saveProducts(Product product) {
    	log.info("In ProductServiceImpl::save()");
    	log.info("Product Data:{}",product);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productRepository.save(productEntity);
        log.info("Product Data Saved in products Table:{}",productEntity);

        return new Product(productEntity.getId(), product.getName(), product.getPrice(), product.getQuantity());
    }

    @Override
    public List<Product> findAll() {
    	log.info("In ProductServiceImpl::findAll()");
        return productRepository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice(), entity.getQuantity()))
                .collect(Collectors.toList());
    }
}
