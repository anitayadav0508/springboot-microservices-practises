package com.rest.client.implementation.using.RestTemplate.controller;

import com.rest.client.implementation.using.RestTemplate.service.QuoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {
    @Autowired
    private QuoteClient quoteClient;

    @GetMapping("/quote")
    public String getQuote(){
        return quoteClient.invokeQuoteApi();

    }
}
