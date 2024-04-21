package com.example.db_booking.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActuatorComponent {


    // todo auth control needed
    @WriteOperation
    public void restartServer() {
        callBookingServerToRestartDb();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.exit(0); // Перезапуск приложения
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    /**
     * Method calls Booking Server endpoint to run Docker file and restart
     * db_booking
     */
    private void callBookingServerToRestartDb() {

        String url = "http://localhost:8081/restart-db";
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(url, HttpMethod.GET,
                new HttpEntity<>(null, null), Void.class);
    }
}
