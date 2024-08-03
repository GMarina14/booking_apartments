package com.example.booking_apartments.service.impl;

import com.example.booking_apartments.model.entity.IntegrationInfoEntity;
import com.example.booking_apartments.repository.IntegrationRepository;
import com.example.booking_apartments.service.GeoCoderManagerService;
import com.example.booking_apartments.service.IntegrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.example.booking_apartments.constant.BookingApplicationConstant.ID_GEO_CONSTANT;
import static com.example.booking_apartments.constant.BookingApplicationConstant.ID_PRODUCT_DISCOUNT;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private final IntegrationRepository integrationRepository;

    //private final RestTemplate restTemplate;
    private final static Logger log = LoggerFactory.getLogger(IntegrationServiceImpl.class);
    private final GeoCoderManagerService geoCoderManagerService;

    @Override

    public String getCityByLocation(String latitude, String longitude) {

        String url = getGeocodedUrl(latitude, longitude);

        log.info("IntegrationServiceImpl : getCityByLocation -> ");
        // String   infoByLocation = geoCoderManagerService.requestToGeo(url);
        String infoByLocation;
        try {
            infoByLocation = geoCoderManagerService.requestToGeo(url);
        } catch (Exception e) {
            throw new RuntimeException("geo coder failed");
        }
        log.info("IntegrationServiceImpl : getCityByLocation <- product_apartment");

        return getParseInfo(infoByLocation);
    }


    @Override
    public void getPreparedDiscountForBooking(Long id, String token) {

        IntegrationInfoEntity integrationInfo = integrationRepository.findById(ID_PRODUCT_DISCOUNT).get();

        log.info("IntegrationServiceImpl : getPreparedDiscountForBooking -> product_apartment");
        String url = integrationInfo.getPathValue();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(
                String.format(url, id),
                HttpMethod.GET,
                new HttpEntity<>(createHeadersWithToken(B64ServiceImpl.getDecode(integrationInfo.getKeyValue()))), //should we decode? if table contains the encoded
                Void.class
        );
        log.info("IntegrationServiceImpl : getPreparedDiscountForBooking <- product_apartment");
    }

    private HttpHeaders createHeadersWithToken(String token) {

        Map<String, String> headers = new HashMap<>();
        headers.put(token, "123");
        HttpHeaders head = new HttpHeaders();
        head.setAll(headers);
        return head;
    }

    private String getGeocodedUrl(String latitude, String longitude) {

        IntegrationInfoEntity integrationInfo = integrationRepository.findById(ID_GEO_CONSTANT).get();

        log.info("IntegrationServiceImpl : getGeocodedUrl -> product_apartment");
        String url = String.format(integrationInfo.getPathValue(),
                latitude,
                longitude,
                B64ServiceImpl.getDecode(integrationInfo.getKeyValue()));
        log.info("IntegrationServiceImpl : getGeocodedUrl <- product_apartment");

        return url;
    }

    private String getParseInfo(String value) {

        ObjectMapper objectMapper = new ObjectMapper();
        log.info("IntegrationServiceImpl : getParseInfo -> product_apartment");
        try {
            JsonNode tree = objectMapper.readTree(value);
            log.info("IntegrationServiceImpl : getParseInfo <- product_apartment");
            return tree.get("results").get(0).get("components").get("city").asText();
        } catch (JsonProcessingException e) {
            log.error("Error parsing json and getting city info");
            throw new RuntimeException(e);
        }

    }
}
