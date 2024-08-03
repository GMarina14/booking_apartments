package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.exception.ApartmentException;
import com.example.booking_apartments.mapper.AddressMapper;
import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.BookingInfoEntity;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.BookingInfoRepository;
import com.example.booking_apartments.service.BookingInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingInfoServiceImpl implements BookingInfoService {

    private final BookingInfoRepository bookingInfoRepository;
    private final AddressMapper addressMapper;

    /**
     * the method checks if the needed apartment is available and if so, creates  a booking reservation
     *
     * @param startDate
     * @param endDate
     * @param apartment
     * @param user
     * @return
     */
    @Override
    public BookingInfoEntity createBookingReservation(LocalDateTime startDate, LocalDateTime endDate, ApartmentEntity apartment, UserRegistrationFormEntity user) {

        checkAvailability(apartment, startDate, endDate);
        BookingInfoEntity bookingInfo = addressMapper.prepareBookingInfoEntity(startDate, endDate, apartment, user);
        bookingInfoRepository.save(bookingInfo);

        return bookingInfo;
    }

    /**
     * the method checks if the needed apartment is available for reservation on the specified dates
     *
     * @param apartment
     * @param startDate
     * @param endDate
     */
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
