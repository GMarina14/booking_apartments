package com.example.booking_apartments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {

    private String message;
    private String token;
}
