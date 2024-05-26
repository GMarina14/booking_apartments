package com.example.booking_apartments.service;

import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;

import java.time.LocalDateTime;

public interface BookingInfoService {

    public BookingInfoEntity createBookingReservation(LocalDateTime startDate, LocalDateTime endDate, ApartmentEntity apartment, UserRegistrationFormEntity user);
}
