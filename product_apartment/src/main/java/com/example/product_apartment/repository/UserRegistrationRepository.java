package com.example.product_apartment.repository;

import com.example.product_apartment.model.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistrationFormEntity, Long> {

    UserRegistrationFormEntity findUserRegistrationFormEntitiesByToken(String token);
}
