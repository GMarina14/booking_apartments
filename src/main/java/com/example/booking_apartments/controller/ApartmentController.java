package com.example.booking_apartments.controller;

import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.service.ApartmentService;
import com.example.booking_apartments.service.AuthService;
import com.example.booking_apartments.service.ReportService;
import com.example.booking_apartments.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;
    private final UserRegistrationService userRegistrationService;
    private final AuthService authService;
    private final ReportService reportService;


    @GetMapping(GET_APARTMENT_BY_ID)
    public ResponseEntity<ApartmentInfoDto> getApartmentById(@PathVariable Long id) {

        return null;
    }

    //
    @PostMapping(value = APARTMENT_REGISTRATION)
    public String apartmentRegistration(@RequestHeader String token,
                                        @RequestBody ApartmentInfoDto apartmentInfoDto) {
        //  todo вынести на перехватчик проверку
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

        return apartmentService.getApartmentsByLocation(latitude, longitude);
    }

    @GetMapping(GET_BOOKING)
    public ApartmentInfoDto getBookingApartment(@RequestHeader(required = false) String token,
                                                @RequestParam(required = false) LocalDateTime startDate,
                                                @RequestParam(required = false) LocalDateTime endDate,
                                                @RequestParam Long id) {
        //    LocalDateTime now = LocalDateTime.now();
        if (!isNull(startDate) && !isNull(endDate)) {


            UserRegistrationFormEntity user = authService.checkValidTokenWithResult(token);
            // return null;
            return apartmentService.bookingApartment(id, user, startDate, endDate);
        }
// todo else

        return apartmentService.showApartment(id);
    }

    @PostMapping(CREATE_REPORT)
    public void createReport() {
        // dates
        reportService.createReport();

    }

}
