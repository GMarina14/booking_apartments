package com.example.booking_apartments.service;

import com.example.booking_apartments.model.dto.AuthFormDto;
import com.example.booking_apartments.model.dto.AuthResponseDto;

public interface AuthService {

    public AuthResponseDto authTheUser(AuthFormDto authForm);
    public void checkValidToken(String token);
}
