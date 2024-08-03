package com.example.product_apartment.repository;

import com.example.product_apartment.model.IntegrationInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntegrationRepository extends JpaRepository<IntegrationInfoEntity, String> {

    Optional<IntegrationInfoEntity> findByKeyValue(String keyValue);
}
