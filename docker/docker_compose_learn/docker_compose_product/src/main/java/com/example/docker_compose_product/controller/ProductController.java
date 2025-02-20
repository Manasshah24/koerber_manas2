package com.example.docker_compose_product.controller;


import com.example.docker_compose_product.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1, "Laptop", 1200.00),
                new Product(2, "Phone", 800.00)
        );
    }
}

