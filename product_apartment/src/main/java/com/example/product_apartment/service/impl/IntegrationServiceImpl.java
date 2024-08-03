package com.example.product_apartment.service.impl;

import com.example.product_apartment.model.IntegrationInfoEntity;
import com.example.product_apartment.repository.IntegrationRepository;
import com.example.product_apartment.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository integrationRepository;

    /**
     * The method checks if integration table contains the token and could get access to data
     * @param token
     * @return
     */
    @Override
    public Optional<IntegrationInfoEntity> checkValidToken(String token) {

        return integrationRepository.findByKeyValue(token);
    }
}
