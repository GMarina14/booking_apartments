package com.example.booking_apartments.controller;

import com.example.booking_apartments.model.dto.AuthFormDto;
import com.example.booking_apartments.model.dto.AuthResponseDto;
import com.example.booking_apartments.model.dto.UserRegistrationFormDto;
import com.example.booking_apartments.service.AuthService;
import com.example.booking_apartments.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.booking_apartments.constant.BookingApplicationConstant.AUTHORISATION;
import static com.example.booking_apartments.constant.BookingApplicationConstant.REGISTRATION;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserRegistrationService userRegistrationService;
    private final AuthService authService;

    @PostMapping(REGISTRATION)
    public String registrationOfNewUser(@RequestBody UserRegistrationFormDto userForm) {

        return userRegistrationService.saveNewUser(userForm);
    }

    @PostMapping(AUTHORISATION)
    public AuthResponseDto authorisationOfTheUser(@RequestBody AuthFormDto authFormDto) {
        return authService.authTheUser(authFormDto);
    }
}
