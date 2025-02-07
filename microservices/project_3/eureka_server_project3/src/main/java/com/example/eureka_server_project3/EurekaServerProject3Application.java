package com.example.eureka_server_project3;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerProject3Application {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerProject3Application.class, args);
	}
}

