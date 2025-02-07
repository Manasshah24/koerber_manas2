package com.example.payment_ms_3.clients;


import com.example.payment_ms_3.dto.Order; // DTO to map response
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-ms-2") // Correct way
public interface OrderClient {
    @GetMapping("/orders/{orderId}")
    Order getOrderById(@PathVariable Long orderId);
}

