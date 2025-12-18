package com.rest.client.implementation.using.RestTemplate.binding;

import java.util.List;

/*
 * This class holds the overall flight API response
 * {
 *   "flights": [
 *     { ... flight1 ... },
 *     { ... flight2 ... }
 *   ]
 * }
 */

/*To represent a list of flight data we are using FlightApiResponse*/
public class Flights {
    private List<Flight> flights;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "FlightApiResponse [flights=" + flights + "]";
    }
}
