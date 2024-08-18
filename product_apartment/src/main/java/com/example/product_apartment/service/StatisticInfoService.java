package com.example.product_apartment.service;

import com.example.product_apartment.model.ApartmentEntity;
import com.example.product_apartment.model.StatisticInfo;

public interface StatisticInfoService {

    StatisticInfo getStatistics(Long apartmentId);
}
