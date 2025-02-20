package com.example.assignment_kafka.controller;


import com.example.assignment_kafka.entity.Order;
import com.example.assignment_kafka.service.OrderProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderProducerService orderProducerService;

    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderProducerService.sendOrder(order);
        return "✅ Order published successfully!";
    }
}

