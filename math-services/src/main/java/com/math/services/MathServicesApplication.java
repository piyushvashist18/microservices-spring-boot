package com.math.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableCircuitBreaker
@EnableDiscoveryClient
public class MathServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathServicesApplication.class, args);
	}

}
