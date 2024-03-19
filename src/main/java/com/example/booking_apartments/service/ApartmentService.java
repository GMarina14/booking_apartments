package com.example.booking_apartments.service;

import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ApartmentService {

    String registrationOfNewApartment(ApartmentInfoDto apartmentInfoDto);

    List<ApartmentInfoDto>  getApartmentsByLocation(String latitude, String longitude);

    String addPhotoOfApartment(Long id, MultipartFile image) throws IOException;

    String bookingApartment(Long id);

}
