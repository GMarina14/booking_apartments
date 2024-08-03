package com.example.booking_apartments.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class bookingExceptionHandler {

    @ExceptionHandler(ApartmentException.class)
    public ResponseEntity<?> catchException(ApartmentException e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ApartmentNotFoundException.class)
    public ResponseEntity<?> catchException(ApartmentNotFoundException e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
