package com.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);
		System.out.println("Hello");
	}

}
