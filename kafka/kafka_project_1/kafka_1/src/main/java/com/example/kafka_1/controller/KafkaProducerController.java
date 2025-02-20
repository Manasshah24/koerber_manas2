package com.example.kafka_1.controller;



import com.example.kafka_1.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {
    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        producerService.sendMessage(message);
        return "Message sent: " + message;
    }
}
