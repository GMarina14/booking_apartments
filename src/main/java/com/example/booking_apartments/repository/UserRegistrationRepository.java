package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationFormEntity, Long> {

    UserRegistrationFormEntity findUserRegistrationFormEntityByNickname(String nickName);

    UserRegistrationFormEntity findUserRegistrationFormEntityByUsername(String userName);




}
