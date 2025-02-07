package com.assignment5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SERVER STARTED ON PORT 3000");
	}
}
