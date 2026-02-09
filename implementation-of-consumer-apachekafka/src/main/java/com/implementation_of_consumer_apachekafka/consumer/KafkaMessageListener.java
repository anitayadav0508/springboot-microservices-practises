package com.implementation_of_consumer_apachekafka.consumer;

import com.implementation_of_consumer_apachekafka.pojo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "Test", groupId = "kafka-consumer-grp", containerFactory = "kafkaListenerContainerFactory")
    public void consumeEvents(Customer customer) {

        logger.info("Consumer consume the pojo message  with value");
        logger.info(customer.toString());
    }


}
