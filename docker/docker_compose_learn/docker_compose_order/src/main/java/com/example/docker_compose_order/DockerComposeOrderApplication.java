package com.example.docker_compose_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.docker_compose_order.client") // Ensure this matches your package structure

public class DockerComposeOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerComposeOrderApplication.class, args);
	}

}

//If you plan to use Docker Compose, keep url = "http://product-service:8082".
//		If you run locally without Docker, change it to url = "http://localhost:8082".