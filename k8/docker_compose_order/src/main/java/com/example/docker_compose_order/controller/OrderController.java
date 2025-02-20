package com.example.docker_compose_order.controller;


import com.example.docker_compose_order.client.ProductClient;
import com.example.docker_compose_order.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final ProductClient productClient;

    public OrderController(ProductClient productClient) {
        this.productClient = productClient;
    }

    // Endpoint to fetch all products from product-service
    @GetMapping("/products")
    public List<ProductDTO> getProductsFromProductService() {
        return productClient.getAllProducts();
    }
}
