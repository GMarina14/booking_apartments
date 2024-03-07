package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.ApartmentEntity;
import com.example.booking_apartments.model.entity.FacilitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilitiesRepository extends JpaRepository<FacilitiesEntity, Long> {


}
