package com.Using.WebClient.implement.asynchronous.communication.controller;

import com.Using.WebClient.implement.asynchronous.communication.binding.Quote;
import com.Using.WebClient.implement.asynchronous.communication.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class QuoteRestController {
    @Autowired
    private QuoteService quoteService;

    @GetMapping("/sync/quote")
    public Quote getRandomQuote(){

        return quoteService.invokeSyncQuoteApi();
    }


    @GetMapping("/async/quote")
    public String getRandomAsyncQuote(){
        return quoteService.invokeAsyncQuoteApi();

    }
}
