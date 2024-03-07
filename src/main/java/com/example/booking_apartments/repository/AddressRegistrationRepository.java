package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRegistrationRepository extends JpaRepository<AddressEntity, Long> {

    AddressEntity findAddressEntityByStreetAndAndStreetNumber(String street, String streetNumber);
}
