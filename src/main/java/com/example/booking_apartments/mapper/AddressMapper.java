package com.example.booking_apartments.mapper;

import com.example.booking_apartments.model.dto.ApartmentInfoDto;
import com.example.booking_apartments.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {

    AddressEntity apartmentInfoDtoToAddress(ApartmentInfoDto apartmentInfoDto);

    ApartmentEntity apartmentInfoDtoToApartment(ApartmentInfoDto apartmentInfoDto);

    ApartmentInfoDto apartmentAndAddressToApartmentInfo(AddressEntity addressEntity, ApartmentEntity apartmentEntity);

    FacilitiesEntity apartmentInfoDtoToFacilities(ApartmentInfoDto apartmentInfoDto);


    default ApartmentEntity prepareEntityByParam(ApartmentEntity apartmentEntity, boolean available, ApartmentInfoDto apartmentInfoDto) {
        apartmentEntity.setAvailability(true);
        apartmentEntity.setAddressEntity(apartmentInfoDtoToAddress(apartmentInfoDto));
        apartmentEntity.setFacilitiesEntity(apartmentInfoDtoToFacilities(apartmentInfoDto));

        return apartmentEntity;
    }


    @Mapping(target = "id", ignore = true)
    BookingInfoEntity prepareBookingInfoEntity(LocalDateTime startDate, LocalDateTime endDate, ApartmentEntity apartment, UserRegistrationFormEntity user);


    // OK?
    @Named("StringToImage")
    default Image stringToImage(String pic) {

        return new Image(pic.getBytes());
    }

    @Named("ImageToString")
    default String imageToString(Image photo) {
        return photo.toString();
    }
}
