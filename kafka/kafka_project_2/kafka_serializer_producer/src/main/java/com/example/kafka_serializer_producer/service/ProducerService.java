package com.example.kafka_serializer_producer.service;

import com.example.kafka_serializer_producer.entity.MyObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final KafkaTemplate<String, MyObject> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, MyObject> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, MyObject message) {
        kafkaTemplate.send("my-topic", key, message);
        System.out.println("Sent message: " + message + " with key: " + key);
    }
}
