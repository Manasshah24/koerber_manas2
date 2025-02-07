package com.example.order_db.clients;


import com.example.order_db.dto.Product; // DTO to map response
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Calls the Product Service at "PRODUCT-SERVICE"
@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:8081")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
