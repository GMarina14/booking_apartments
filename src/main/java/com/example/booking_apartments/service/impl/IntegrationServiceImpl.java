package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.repository.IntegrationRepository;
import com.example.booking_apartments.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository integrationRepository;

    @Override
    public URL getGeocodedUrl(String latitude, String longitude) {

        //?????? decode?
        String key= "dfcb67fbb3b74d3b8c01dba2a3ecefe0";

        // Must be URL encoded ????

        try {
            URL url = new URL(String.format("https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s", latitude, longitude, key));
            return url;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
