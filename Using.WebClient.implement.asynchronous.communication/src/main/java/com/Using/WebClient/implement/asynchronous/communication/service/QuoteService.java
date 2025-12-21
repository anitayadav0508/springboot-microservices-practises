package com.Using.WebClient.implement.asynchronous.communication.service;

import com.Using.WebClient.implement.asynchronous.communication.binding.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class QuoteService {

    private final WebClient webClient;
    // Using ZenQuotes API - reliable and free
    @Value("${quote.api.url}")
    private String apiUrl ;

    public QuoteService() {
        this.webClient = WebClient.create();
    }

    public  Quote invokeSyncQuoteApi() {


        return webClient.get()
                .uri(apiUrl)
                .header("Accept","application/json")
                .accept(MediaType.APPLICATION_JSON)

                .retrieve()
                .bodyToMono(Quote.class)
                .block();

    }

    /*This is a async request instead of waiting of handleResponse method execution
    it print immediately system.out.println statement i.e "Request Sent"*/
    public String invokeAsyncQuoteApi(){

                webClient.get()
                .uri(apiUrl)
                        .header("Accept","application/json")
                .retrieve()
                .bodyToMono(Quote.class)
                .subscribe(QuoteService::handleResponse);
        System.out.println("************Request Sent*************"); // this line print immediately
        return "Success";
    }

    /*This is a consumer/handler who consume the 3rd api response*/
    public static void handleResponse(Quote resData){
        System.out.println(resData); // this line executes after few seconds when response comes from 3rd party api
        System.out.println("Response pushed to Apache kafka......");

    }

}
