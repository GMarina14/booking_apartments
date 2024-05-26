package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.exception.ApartmentException;
import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.model.entity.ProductInfoEntity;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.BookingInfoRepository;
import com.example.booking_apartments.service.BookingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingInfoServiceImpl implements BookingInfoService {

    private final BookingInfoRepository bookingInfoRepository;
    private final ProductServiceImpl productService;

    @Override
    public BookingInfoEntity createBookingReservation(LocalDateTime startDate, LocalDateTime endDate, ApartmentEntity apartment, UserRegistrationFormEntity user) {

        checkAvailability(apartment, startDate, endDate);
        BookingInfoEntity bookingInfo = new BookingInfoEntity();


        bookingInfo.setStartDate(startDate);
        bookingInfo.setEndDate(endDate);
        bookingInfo.setApartment(apartment);
        bookingInfo.setUser(user);

        bookingInfoRepository.save(bookingInfo);
// transfer to product module
        ProductInfoEntity discount = productService.getDiscount(bookingInfo);

        bookingInfo.setDiscount(discount);
        bookingInfo.setPrice(apartment.getPrice() * (1.0 - discount.getDiscount() / 100));

        bookingInfoRepository.save(bookingInfo);

        return bookingInfo;
    }

    private void checkAvailability(ApartmentEntity apartment, LocalDateTime startDate, LocalDateTime endDate) {
        List<BookingInfoEntity> bookingInfoEntitiesByApartment = bookingInfoRepository.findBookingInfoEntitiesByApartment(apartment);

        if (!bookingInfoEntitiesByApartment.isEmpty()) {
            for (BookingInfoEntity info : bookingInfoEntitiesByApartment) {
                if (startDate.isBefore(info.getEndDate()) && startDate.isAfter(info.getStartDate())) {
                    throw new ApartmentException("Apartment is not available");
                } else if (endDate.isBefore(info.getEndDate()) && endDate.isAfter(info.getStartDate())) {
                    throw new ApartmentException("Apartment is not available");
                }
            }
        }
    }


}
