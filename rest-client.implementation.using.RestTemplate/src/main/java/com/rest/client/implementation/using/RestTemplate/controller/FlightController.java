package com.rest.client.implementation.using.RestTemplate.controller;

import com.rest.client.implementation.using.RestTemplate.binding.Flights;
import com.rest.client.implementation.using.RestTemplate.service.FlightClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @Autowired
    private FlightClient flightClient;

    @GetMapping("/flights")
    public Flights getFlights() {
       Flights response = flightClient.invokeFlightApi();
        if (response != null) {
            return response;
        }
        return null;
    }
}
