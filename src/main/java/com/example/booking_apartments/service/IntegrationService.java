package com.example.booking_apartments.service;

import java.net.URL;

public interface IntegrationService {

    String getCityByLocation(String latitude, String longitude);

    String getPreparedDiscountForBooking(Long id);

}
