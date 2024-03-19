package com.example.product_apartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductApartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApartmentApplication.class, args);
	}
}
