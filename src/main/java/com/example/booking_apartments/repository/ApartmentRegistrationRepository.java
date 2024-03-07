package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.AddressEntity;
import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.UserRegistrationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRegistrationRepository extends JpaRepository<ApartmentEntity, Long> {

    ApartmentEntity findApartmentEntityByPropertyNameAndAddressEntity(String propertyName, AddressEntity addressEntity);


}
