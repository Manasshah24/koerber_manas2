package com.example.kafka_serializer_consumer.service;


import com.example.kafka_serializer_consumer.entity.MyObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consumeMessage(MyObject message) {
        System.out.println("Received Message: " + message);
    }
}
