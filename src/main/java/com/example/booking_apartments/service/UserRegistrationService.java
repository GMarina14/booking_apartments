package com.example.booking_apartments.service;

import com.example.booking_apartments.model.dto.UserRegistrationFormDto;

public interface UserRegistrationService {

    public String saveNewUser(UserRegistrationFormDto userForm);

}
