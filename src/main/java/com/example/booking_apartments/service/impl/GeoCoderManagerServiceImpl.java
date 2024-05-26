package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.service.GeoCoderManagerService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoCoderManagerServiceImpl implements GeoCoderManagerService {
    @Override
    public String requestToGeo(String url) {

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(url,
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                String.class).getBody();
    }
}
