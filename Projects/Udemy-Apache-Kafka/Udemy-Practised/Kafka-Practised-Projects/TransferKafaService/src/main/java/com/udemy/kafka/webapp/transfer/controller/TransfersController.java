package com.udemy.kafka.webapp.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.kafka.webapp.transfer.dto.TransferRestModel;
import com.udemy.kafka.webapp.transfer.service.TransferServiceImpl;

@RestController
@RequestMapping("/transfers")
public class TransfersController {

	@Autowired
	TransferServiceImpl transferServiceImpl;

	@PostMapping()
	public boolean transfer(@RequestBody TransferRestModel transferRestModel) {
		return transferServiceImpl.transfer(transferRestModel);
	}
}
