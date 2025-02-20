package com.example.assignment_kafka.service;



import com.example.assignment_kafka.entity.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final String topic = "order-topic"; // Kafka topic name

    public OrderProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {
        kafkaTemplate.send(topic, order);
        System.out.println("✅ Order sent: " + order);
    }
}
