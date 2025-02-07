package com.example.order_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // Enables Feign Clients
public class OrderDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderDbApplication.class, args);
	}
}
