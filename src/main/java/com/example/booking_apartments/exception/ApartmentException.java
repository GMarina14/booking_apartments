package com.example.booking_apartments.exception;

public class ApartmentException extends RuntimeException{

    public static final String NOT_FOUND_MESSAGE= "Apartment by id was not found";

    public ApartmentException(String message) {
        super(message);
    }
}
