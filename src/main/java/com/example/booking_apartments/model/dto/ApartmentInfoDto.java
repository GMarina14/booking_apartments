package com.example.booking_apartments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentInfoDto {
    private String zipCode;
    private String country;
    private String region;
    private String city;
    private String street;
    private String streetNumber;
    private String apartmentNumber;
    private String googleMapsUrl;
    // facilities
    private boolean wiFi;
    private boolean parking;
    private boolean airConditioning;
    private boolean housekeeping;
    private boolean terrace;
    private boolean garden;
    private boolean beach;
    private boolean heating;
    private boolean swimmingPool;
    private boolean bar;
    ///////
    private String propertyName;
    private Double price;
    private Integer paymentOptions;
    private Integer roomsQuantity;
    private Integer occupancy;
    private Integer freeCancellationDaysBeforeArrival;
    ////


}
