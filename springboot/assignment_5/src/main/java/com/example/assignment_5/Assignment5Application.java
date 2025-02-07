package com.example.assignment_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.assignment_5.repository")  // Ensure repositories are scanned
public class Assignment5Application {
	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}
}
