package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint. No authentication required.";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello User! You have USER access.";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello Admin! You have ADMIN access.";
    }
}
