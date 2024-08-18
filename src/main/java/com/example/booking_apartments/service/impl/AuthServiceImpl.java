package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.exception.UserException;
import com.example.booking_apartments.model.dto.AuthFormDto;
import com.example.booking_apartments.model.dto.AuthResponseDto;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import com.example.booking_apartments.repository.AuthRepository;
import com.example.booking_apartments.repository.UserRegistrationRepository;
import com.example.booking_apartments.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.booking_apartments.constant.BookingApplicationConstant.*;
import static com.example.booking_apartments.constant.BookingApplicationConstant.NON_VALID_TOKEN;
import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRegistrationRepository userRegistrationRepository;
    private final AuthRepository authRepository;


    @Override
    public AuthResponseDto authTheUser(AuthFormDto authForm) {

        UserRegistrationFormEntity userByUsername = userRegistrationRepository.findUserRegistrationFormEntityByUsername(authForm.getUsername());
        if (isNull(userByUsername)) {
            throw new UserException(USER_DOESNT_EXIST);
        }
        if (!userByUsername.getPassword().equals(authForm.getPassword())) {
            throw new UserException(PASSWORD_INCORRECT);
        }

        String token = generateSessionToken();

        userByUsername.setToken(B64ServiceImpl.getEncode(token));
        userRegistrationRepository.save(userByUsername);

        return new AuthResponseDto(USER_AUTHORISATION_SUCCESSFUL, token);
    }

    @Override
    public void checkValidToken(String token) {
        UserRegistrationFormEntity user = getUserByToken(token);
        if (isNull(user)) {
            throw new UserException(NON_VALID_TOKEN);
        }
    }

    public UserRegistrationFormEntity checkValidTokenWithResult(String token) {
        checkValidToken(token);
        return getUserByToken(token);
    }

    private UserRegistrationFormEntity getUserByToken(String token) {
        return authRepository.findUserRegistrationFormEntitiesByToken(B64ServiceImpl.getEncode(token));
    }

    private String generateSessionToken() {

        return UUID.randomUUID().toString() + "|" + LocalDateTime.now().plusDays(1);
    }
}
