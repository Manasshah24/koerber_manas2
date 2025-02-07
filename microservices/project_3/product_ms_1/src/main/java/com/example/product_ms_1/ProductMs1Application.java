package com.example.product_ms_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Enables Eureka Client
public class ProductMs1Application {
	public static void main(String[] args) {
		SpringApplication.run(ProductMs1Application.class, args);
	}
}
