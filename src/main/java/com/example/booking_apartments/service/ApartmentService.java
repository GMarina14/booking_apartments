package com.example.booking_apartments.service;

import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface ApartmentService {

    String registrationOfNewApartment(ApartmentInfoDto apartmentInfoDto);

    List<ApartmentInfoDto>  getApartmentsByLocation(String latitude, String longitude);

    String addPhotoOfApartment(Long id, MultipartFile image) throws IOException;

    ApartmentInfoDto  bookingApartment(Long id, UserRegistrationFormEntity user, LocalDateTime startDate, LocalDateTime endDate);

}
