package com.example.order_db.controller;



import com.example.order_db.entity.Order;
import com.example.order_db.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{productId}/{quantity}")
    public Order placeOrder(@PathVariable Long productId, @PathVariable int quantity) {
        return orderService.placeOrder(productId, quantity);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
