package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.exception.ApartmentNotFoundException;
import com.example.booking_apartments.mapper.AddressMapper;
import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.model.entity.AddressEntity;
import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.FacilitiesEntity;
import com.example.booking_apartments.model.entity.Image;
import com.example.booking_apartments.repository.AddressRegistrationRepository;
import com.example.booking_apartments.repository.ApartmentRegistrationRepository;
import com.example.booking_apartments.repository.FacilitiesRepository;
import com.example.booking_apartments.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
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
    public String bookingApartment(Long id) {

        return integrationService.getPreparedDiscountForBooking(id);
    }

    @Override
    public List<ApartmentInfoDto> getApartmentsByLocation(String latitude, String longitude) {

        String city = integrationService.getCityByLocation(latitude, longitude);
        List<AddressEntity> addressEntitiesByCity = addressRegistrationRepository.findAddressEntitiesByCity(city);
        return addressEntitiesByCity.stream()
                .map(a -> addressMapper.apartmentAndAddressToApartmentInfo(a, a.getApartmentEntity()))
                .collect(Collectors.toList());
    }


}
