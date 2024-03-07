package com.example.booking_apartments.repository;

import com.example.booking_apartments.model.entity.IntegrationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegrationRepository extends JpaRepository<IntegrationInfoEntity, String> {

}
