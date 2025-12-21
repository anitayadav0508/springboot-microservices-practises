package com.Using.WebClient.implement.asynchronous.communication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Locale;

@Service
public class CustomerEventService {
    private String REST_URL1 = "http://localhost:9093/getEvent";
    private String REST_URL2 = "http://localhost:9093/getEvents";

    public void invokeFluxCustomerEvent(){
        WebClient.Builder builder = WebClient.builder();
        WebClient webClient = builder.build();
        String eventResponse   =  webClient.get()
                                      .uri(REST_URL1)
                                      .retrieve()
                                      .bodyToMono(String.class)
                                      .block();
        System.out.println(eventResponse);
    }

    public void invokeMonoCustomerEvents(){
        WebClient.Builder builder = WebClient.builder();
        WebClient webClient = builder.build();
        webClient.get()
                 .uri(REST_URL2)
                 .retrieve()
                 .bodyToFlux(String.class)
                 .subscribe(System.out:: println); 
    }
}
