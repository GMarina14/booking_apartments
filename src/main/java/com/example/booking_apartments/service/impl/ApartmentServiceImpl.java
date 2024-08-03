package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.exception.ApartmentException;
import com.example.booking_apartments.exception.ApartmentNotFoundException;
import com.example.booking_apartments.mapper.AddressMapper;
import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.model.entity.*;
import com.example.booking_apartments.repository.AddressRegistrationRepository;
import com.example.booking_apartments.repository.ApartmentRegistrationRepository;
import com.example.booking_apartments.repository.FacilitiesRepository;
import com.example.booking_apartments.service.ApartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
import static com.example.booking_apartments.exception.ApartmentException.NOT_FOUND_MESSAGE;
import static java.util.Objects.isNull;


@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRegistrationRepository apartmentRegistrationRepository;
    private final AddressRegistrationRepository addressRegistrationRepository;
    private final FacilitiesRepository facilitiesRepository;
    private final AddressMapper addressMapper;
    private final ImageServiceImpl imageService;
    private final IntegrationServiceImpl integrationService;
    private final UserRegistrationServiceImpl userRegistrationService;
    private final BookingInfoServiceImpl bookingInfoService;
    private final KafkaTemplate<String, String> template;

    private final String TOPIC_POST_PROCESSING = "topic_post_processing";


    @Override
    public String registrationOfNewApartment(ApartmentInfoDto apartmentInfoDto) {

        ApartmentEntity apartmentEntity = addressMapper.apartmentInfoDtoToApartment(apartmentInfoDto);
        AddressEntity addressEntity = addressMapper.apartmentInfoDtoToAddress(apartmentInfoDto);
        FacilitiesEntity facilitiesEntity = addressMapper.apartmentInfoDtoToFacilities(apartmentInfoDto);


        if (!isNull(apartmentRegistrationRepository.findApartmentEntityByPropertyNameAndAddressEntity(apartmentEntity.getPropertyName(),
                addressRegistrationRepository.findAddressEntityByStreetAndAndStreetNumber(addressEntity.getStreet(), addressEntity.getStreetNumber())))) {
            throw new RuntimeException(PROPERTY_ALREADY_REGISTERED);

        } else {
            ApartmentEntity apartment = addressMapper.prepareEntityByParam(apartmentEntity, true, apartmentInfoDto);
            apartmentRegistrationRepository.save(apartment);
        }
        return APARTMENT_REGISTRATION_SUCCESSFUL;
    }

    @Override
    public String addPhotoOfApartment(Long id, MultipartFile image) throws IOException {

        ApartmentEntity apartmentEntity = apartmentRegistrationRepository.findById(id).orElseThrow(() -> new ApartmentNotFoundException("Apartment is not found"));

        Image pic = imageService.saveToDb(image);
        apartmentEntity.setImage(pic);
        apartmentRegistrationRepository.save(apartmentEntity);

        return APARTMENT_PHOTOS_UPLOAD_SUCCESSFUL;
    }

    @Override
    @Transactional
    public ApartmentInfoDto bookingApartment(Long id, UserRegistrationFormEntity user, LocalDateTime startDate, LocalDateTime endDate) {


        ApartmentEntity apartment = apartmentRegistrationRepository.findById(id).orElseThrow(() -> new ApartmentNotFoundException("apartment not found"));
        getInfoAboutAvailability(apartment);

        BookingInfoEntity reservation = bookingInfoService.createBookingReservation(startDate, endDate, apartment, user);

        try {
            integrationService.getPreparedDiscountForBooking(reservation.getId(), user.getToken());
        } catch (Exception e) {

            template.send(TOPIC_POST_PROCESSING, reservation.getId().toString());
            throw new ApartmentException("Your discount info of the booked apartment by location " + apartment.getAddressEntity().getStreetNumber() + " will be send to your email within 24 hours");
        }


        //
       /* getDiscount()
        try{
            sendMassage()
        }catch(){
            // скидка будет выслана в течение 24 часов
        }*/


        return addressMapper.apartmentAndAddressToApartmentInfo(apartment.getAddressEntity(), apartment);
        //integrationService.getPreparedDiscountForBooking(id);
    }

    @Override
    public ApartmentInfoDto showApartment(Long id) {

        ApartmentEntity apartment = apartmentRegistrationRepository.findById(id).orElseThrow(() -> new ApartmentException(NOT_FOUND_MESSAGE));
        return addressMapper.apartmentAndAddressToApartmentInfo(apartment.getAddressEntity(), apartment);
    }

    @Override
    public List<ApartmentInfoDto> getApartmentsByLocation(String latitude, String longitude) {

        String city = integrationService.getCityByLocation(latitude, longitude);
        List<AddressEntity> addressEntitiesByCity = addressRegistrationRepository.findAddressEntitiesByCity(city);
        return addressEntitiesByCity.stream()
                .map(a -> addressMapper.apartmentAndAddressToApartmentInfo(a, a.getApartmentEntity()))
                .collect(Collectors.toList());
    }

    private void getInfoAboutAvailability(ApartmentEntity apartment) {

        if (!apartment.isAvailability()) {
            throw new ApartmentException("Apartment is not available");
        }
        //todo проверяем на даты бронирования

        apartment.setAvailability(false);
        apartmentRegistrationRepository.save(apartment);

    }
}
