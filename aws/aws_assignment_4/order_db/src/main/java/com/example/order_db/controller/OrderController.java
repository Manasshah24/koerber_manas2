package com.example.order_db.controller;



import com.example.order_db.service.OrderService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam String productId) {
        orderService.sendMessage(productId);
        return "Order placed for product ID: " + productId;
    }
}
