package com.example.kafka_serializer_producer.controller;

import com.example.kafka_serializer_producer.entity.MyObject;
import com.example.kafka_serializer_producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String key, @RequestBody MyObject message) {
        producerService.sendMessage(key, message);
        return "Message sent successfully!";
    }
}
