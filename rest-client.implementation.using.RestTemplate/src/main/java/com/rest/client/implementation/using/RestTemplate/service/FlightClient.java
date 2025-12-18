package com.rest.client.implementation.using.RestTemplate.service;

import com.rest.client.implementation.using.RestTemplate.binding.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightClient {

    @Autowired
    private RestTemplate restTemplate;

    // Using npoint.io API
    public static final String api_endpoint_url = "https://api.npoint.io/a8690b6daa74e0bc1dfe";
    
    public Flights invokeFlightApi(){
        /*Rest Template object is created in RestTemplateConfig due to access denied of airline api access without certificates etc */
        // we get json response from 3rd party api , to convert json to object to given java class object , we use 2nd parameter inside getForEntity() method
        ResponseEntity<Flights> response = restTemplate.getForEntity(api_endpoint_url, Flights.class);
        //Access Indigo flight API
        // Access AirAsia Flight API
        // Access Vistara Flight API

        //combined the json all above 3rd api result
        // Here one controller is sufficient like enduser will do query i need all flight for xy date at this time instead of selected specific airline.
        int statusCode = response.getStatusCode().value();
        if (statusCode == 200) {
            Flights body = response.getBody();
           return body;

        }
        return null;
    }
}
