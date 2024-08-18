package com.example.product_apartment.service.impl;

import com.example.product_apartment.model.StatisticInfo;
import com.example.product_apartment.service.StatisticInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticInfoServiceImpl implements StatisticInfoService {

    @Override
    public StatisticInfo getStatistics(Long apartmentId) {
        return null;
    }
}
