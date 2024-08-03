package com.example.product_apartment.service;

import com.example.product_apartment.model.IntegrationInfoEntity;

import java.util.Optional;

public interface IntegrationService {

    Optional<IntegrationInfoEntity> checkValidToken(String token);
}
