package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.mapper.UserRegistrationMapper;
import com.example.booking_apartments.model.dto.UserRegistrationFormDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.UserRegistrationRepository;
import com.example.booking_apartments.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRegistrationRepository userRegistrationRepository;
    private final UserRegistrationMapper userRegistrationMapper;


    @Override
    public String saveNewUser(UserRegistrationFormDto userRegistrationFormDto) {

        UserRegistrationFormEntity userByNickname = userRegistrationRepository.findUserRegistrationFormEntityByNickname(userRegistrationFormDto.getNickname());

        if (!isNull(userByNickname)) {
            return NON_UNIQUE_NICKNAME;
        }

        UserRegistrationFormEntity userByUsername = userRegistrationRepository.findUserRegistrationFormEntityByUsername(userRegistrationFormDto.getUsername());

        if (!isNull(userByUsername)) {
            return NON_UNIQUE_USERNAME;
        }

        UserRegistrationFormEntity userRegistrationForm = userRegistrationMapper.userFormDtoUserForm(userRegistrationFormDto);
        userRegistrationRepository.save(userRegistrationForm);

        return USER_REGISTRATION_SUCCESSFUL;
    }


}
