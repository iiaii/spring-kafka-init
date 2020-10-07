package me.iiaii.springkafka.controllers;


import me.iiaii.springkafka.services.Producer;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final Producer producer;

    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/kafka/publish")
    public String sendMessage(@RequestParam("message") String message) {

        this.producer.sendMessage(message);

        return "Published successfully";
    }

    @Bean
    public NewTopic adviceTopic() {
        return new NewTopic("user", 3, (short) 1);
    }
}
