package com.example.assignment_kafka_consumer.service;


import com.example.assignment_kafka_consumer.entity.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {

    @KafkaListener(topics = "order-topic", groupId = "order-group", containerFactory = "orderKafkaListenerContainerFactory")
    public void consumeOrder(Order order) {
        System.out.println("✅ Order received and being processed: " + order);
        // Simulate order processing (you can save it to a database)
    }
}
