package com.udemy.saga.webapp.credicard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.saga.webapp.credicard.dto.CreditCardProcessRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("creditCard")
@Slf4j
public class CreditCardProcessorController {

    @PostMapping("/process")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void processCreditCard(@RequestBody CreditCardProcessRequest request) {
        log.info("Processing request: {}", request);
    }
}
