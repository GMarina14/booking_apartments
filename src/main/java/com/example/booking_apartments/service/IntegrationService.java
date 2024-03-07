package com.example.booking_apartments.service;

import java.net.URL;

public interface IntegrationService {

    URL getGeocodedUrl(String latitude, String longitude);

}
