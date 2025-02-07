package com.example.payment_ms_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient // Enables Eureka Client
@EnableFeignClients(basePackages = "com.example.payment_ms_3.clients")
public class PaymentMs3Application {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMs3Application.class, args);
	}
}
