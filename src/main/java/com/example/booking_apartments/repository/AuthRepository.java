package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<UserRegistrationFormEntity, Long> {
    UserRegistrationFormEntity findUserRegistrationFormEntitiesByToken(String token);

    List<UserRegistrationFormEntity> findUserRegistrationFormEntitiesByTokenIsNotNull();
}
