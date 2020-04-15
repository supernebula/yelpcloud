package com.evol.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class YelpWebMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(YelpWebMobileApplication.class, args);
	}

}
