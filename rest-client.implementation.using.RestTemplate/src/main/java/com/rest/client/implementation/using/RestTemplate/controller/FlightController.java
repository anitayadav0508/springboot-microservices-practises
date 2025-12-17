package com.rest.client.implementation.using.RestTemplate.controller;

import com.rest.client.implementation.using.RestTemplate.binding.FlightApiResponse;
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
    public FlightApiResponse getFlights() {
        ResponseEntity<FlightApiResponse> response = flightClient.invokeFlightApi();
        if (response != null) {
            return response.getBody();
        }
        return null;
    }
}
