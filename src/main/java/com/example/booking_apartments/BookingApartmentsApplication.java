package com.example.booking_apartments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingApartmentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApartmentsApplication.class, args);
    }

}
