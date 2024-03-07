package com.example.booking_apartments.mapper;

import com.example.booking_apartments.model.dto.UserRegistrationFormDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRegistrationMapper {
    UserRegistrationFormEntity userFormDtoUserForm(UserRegistrationFormDto userRegistrationFormDto);
    UserRegistrationFormDto userFormToUserFormDto(UserRegistrationFormEntity userRegistrationForm);

}
