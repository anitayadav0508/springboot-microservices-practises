package com.implementation_of_producer_apachekafka.controller;

import com.implementation_of_producer_apachekafka.pojo.Customer;
import com.implementation_of_producer_apachekafka.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {

                publisher.sendMessageToTopic(message);


            return new ResponseEntity<>("Message published successfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/publish")
    public void sendEventsToTopic(@RequestBody Customer customer){
        publisher.sendEventsToTopic(customer);

    }

}
