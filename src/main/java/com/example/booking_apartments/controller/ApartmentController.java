package com.example.booking_apartments.controller;

import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.service.ApartmentService;
import com.example.booking_apartments.service.AuthService;
import com.example.booking_apartments.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;

@RestController
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final UserRegistrationService userRegistrationService;
    private final AuthService authService;


    @GetMapping(GET_APARTMENT_BY_ID)
    public ResponseEntity<ApartmentInfoDto> getApartmentById(@PathVariable Long id) {

        return null;
    }

    //
    @PostMapping(value = APARTMENT_REGISTRATION)
    public String apartmentRegistration(@RequestHeader String token,
                                        @RequestBody ApartmentInfoDto apartmentInfoDto) {
        authService.checkValidToken(token);
        return apartmentService.registrationOfNewApartment(apartmentInfoDto);
    }


    @PostMapping(value = ADD_IMAGE_OF_APARTMENT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addPhotoOfApartment(@RequestHeader String token,
                                      @RequestParam Long id,
                                      @RequestParam MultipartFile image) throws IOException {
        authService.checkValidToken(token);
        //todo проверка роли пользователя и что это он размещал

        return apartmentService.addPhotoOfApartment(id, image);
    }


    @GetMapping(GET_APARTMENTS_BY_LOCATION)
    public List<ApartmentInfoDto> getApartmentByLocation(@RequestParam String latitude, @RequestParam String longitude) {

        return null;

    }


}
