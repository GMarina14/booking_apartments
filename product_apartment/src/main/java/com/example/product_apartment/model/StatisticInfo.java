package com.example.product_apartment.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "statistics_of_booking")
public class StatisticInfo {


    private ApartmentEntity apartment;

    private Integer quantityOfBookings;

    private Double rentalIncome;

    private Double incomeAfterDiscount;

    private LocalDateTime timeOfStatisticRequest;

    public StatisticInfo(ApartmentEntity apartment, Integer quantityOfBookings, Double rentalIncome, Double incomeAfterDiscount) {
        this.apartment = apartment;
        this.quantityOfBookings = quantityOfBookings;
        this.rentalIncome = rentalIncome;
        this.incomeAfterDiscount = incomeAfterDiscount;
        this.timeOfStatisticRequest = LocalDateTime.now();
    }
}
