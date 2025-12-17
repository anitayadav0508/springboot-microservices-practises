package com.rest.client.implementation.using.RestTemplate.service;

import com.rest.client.implementation.using.RestTemplate.binding.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteClient {

    /*This is First Approach*/
    public String invokeRandomQuoteApi() {
        String apiUrl = "https://dummyjson.com/quotes/random";
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> responseEntity = rt.getForEntity(apiUrl, String.class);
        int statusCode = responseEntity.getStatusCode().value();
        if (statusCode == 200) {
            String body = responseEntity.getBody();
            return body;
        }
        return null;
    }

    /*This is second approach method & this is preferable*/
    public String invokeQuoteApi() {
        String apiUrl = "https://dummyjson.com/quotes/random";
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Value> responseEntity = rt.getForEntity(apiUrl, Value.class);
        int statusCode = responseEntity.getStatusCode().value();
        if (statusCode == 200) {
            Value body = responseEntity.getBody();
            return body.getQuote().toUpperCase();
        }
        return null;
    }
}
