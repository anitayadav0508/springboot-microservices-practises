package com.mono.vs.Flux.Rest.Api.Implementation.controller;

import com.mono.vs.Flux.Rest.Api.Implementation.event.CustomerEvent;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
public class CustomerRestController {

    @GetMapping(value = "/getEvent", produces = {"application/json"})
    public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent(){
        CustomerEvent event = new CustomerEvent("John", new Date());
        /*To convert java object to Mono we use Mono.just()*/
        Mono<CustomerEvent> customerMono = Mono.just(event);
        ResponseEntity<Mono<CustomerEvent>> responseEntity = new ResponseEntity<Mono<CustomerEvent>>(customerMono, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(value = "/getEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents(){
        //Creating Pojo object with data
        CustomerEvent event = new CustomerEvent("Smith",new Date());
        //Creating Stream object to send data
        Stream<CustomerEvent> customerStream = Stream.generate(() -> event);
        //Giving Stream object to Flux object
        Flux<CustomerEvent> ceflux = Flux.fromStream(customerStream);
        //Setting Response Interval
        //every 3 seconds i want to send response
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));

        //Combining IntervalFlux and CustomerEventFlux
        Flux<Tuple2<Long,CustomerEvent>> zip = Flux.zip(interval,ceflux);

        // we are getting our flex map
        Flux<CustomerEvent> fluxMap = zip.map(Tuple2:: getT2);
        //Tuple2 contain actually data while Tuple1 contain id only so use Tuple2

        // Adding Flux object to Response Body
        ResponseEntity<Flux<CustomerEvent>> resEntity =
                new ResponseEntity<Flux<CustomerEvent>>(fluxMap,HttpStatus.OK);
        //Returning ResEntity with Flux
        return resEntity;


    }
}

