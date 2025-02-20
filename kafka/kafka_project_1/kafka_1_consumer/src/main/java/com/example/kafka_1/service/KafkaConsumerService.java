package com.example.kafka_1.service;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "hello-world-topic", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
