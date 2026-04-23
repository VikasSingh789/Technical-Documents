package com.udemy.kafka.wepapp.producer.service;

import com.udemy.kafka.wepapp.producer.dto.CreateProductRestModel;

public interface ProductService {
	
	String createProductAsync(CreateProductRestModel productRestModel) throws Exception ;
	String createProductSync(CreateProductRestModel productRestModel) throws Exception ;

}
