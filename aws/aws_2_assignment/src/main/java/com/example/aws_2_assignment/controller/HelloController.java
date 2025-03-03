package com.example.aws_2_assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation makes it a REST controller
public class HelloController {

    @GetMapping("/hello") // Maps GET requests to /hello
    public String hello() {
        return "Hello!";
    }

    // You can add more endpoints here if needed
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return "Greetings!";
    }

}
