package com.example.db_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DbBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbBookingApplication.class, args);
	}

}
