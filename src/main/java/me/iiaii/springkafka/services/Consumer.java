package me.iiaii.springkafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "user")
    public void consume(String message) {
        System.out.println("!@#");
        logger.info(String.format("********** Consumer just receive the message -> %s", message));
    }
}
