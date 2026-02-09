package com.implementation_of_producer_apachekafka.service;

import com.implementation_of_producer_apachekafka.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;


    public void sendMessageToTopic(String message){

        CompletableFuture<SendResult<String, Object>> future = template.send("Test",2,null, message);
        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Sent message= [" + message + "] with " +
                        "offset=[" + result.getRecordMetadata().offset() + "]");
            }else{
                System.out.println("Unable to send message due to " + ex.getMessage());
            }
        });

    }
    public void sendEventsToTopic(Customer customer){

        CompletableFuture<SendResult<String, Object>> future = template.send("Test",2,null, customer);
        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Sent message= [" + customer + "] with " +
                        "offset=[" + result.getRecordMetadata().offset() + "]");
            }else{
                System.out.println("Unable to send message due to " + ex.getMessage());
            }
        });

    }


}
