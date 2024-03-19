package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.model.entity.IntegrationInfoEntity;
import com.example.booking_apartments.repository.IntegrationRepository;
import com.example.booking_apartments.service.IntegrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

import static com.example.booking_apartments.constant.BookingApplicationConstant.ID_GEO_CONSTANT;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository integrationRepository;

    //private final RestTemplate restTemplate;

    @Override
    public String getCityByLocation(String latitude, String longitude) {

        String url = getGeocodedUrl(latitude, longitude);
        RestTemplate restTemplate = new RestTemplate();

        String infoByLocation = restTemplate.exchange(url,
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                String.class).getBody();

        return getParseInfo(infoByLocation);

    }

    //
    @Override
    public String getPreparedDiscountForBooking(Long id) {

        String url = "http://localhost:9098/test?id=%s";
        RestTemplate restTemplate = new RestTemplate();

       return restTemplate.exchange(String.format(url, id),
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                String.class).getBody();
    }

    private String getGeocodedUrl(String latitude, String longitude) {

        IntegrationInfoEntity integrationInfo = integrationRepository.findById(ID_GEO_CONSTANT).get();

        String url = String.format(integrationInfo.getPathValue(),
                latitude,
                longitude,
                B64ServiceImpl.getDecode(integrationInfo.getKeyValue()));
        return url;
    }

    private String getParseInfo(String value) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode tree = objectMapper.readTree(value);
            return tree.get("results").get(0).get("components").get("city").asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
