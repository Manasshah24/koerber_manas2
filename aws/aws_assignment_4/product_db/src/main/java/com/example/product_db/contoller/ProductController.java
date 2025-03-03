package com.example.product_db.contoller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/status")
    public String getStatus() {
        return "Product Service is Running";
    }
}

