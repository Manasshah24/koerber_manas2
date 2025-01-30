package com.example.project2.service;


import org.springframework.stereotype.Service;

@Service
public class LoggingService {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
