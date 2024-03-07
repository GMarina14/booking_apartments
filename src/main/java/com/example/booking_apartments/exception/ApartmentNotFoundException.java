package com.example.booking_apartments.exception;

public class ApartmentNotFoundException extends RuntimeException {
    public ApartmentNotFoundException(String message){
        super(message);
    }
}
