package com.example.order_ms_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // Enables Eureka Client
@EnableFeignClients(basePackages = "com.example.order_ms_2.clients")
public class OrderMs2Application {
	public static void main(String[] args) {
		SpringApplication.run(OrderMs2Application.class, args);
	}
}
