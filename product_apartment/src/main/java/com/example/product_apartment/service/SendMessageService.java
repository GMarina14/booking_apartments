package com.example.product_apartment.service;


import com.example.product_apartment.model.BookingInfoEntity;
import com.example.product_apartment.model.UserRegistrationFormEntity;

public interface SendMessageService {

    void sendMessage(Long bookingId);

}
