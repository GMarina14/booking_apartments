package com.example.db_booking.component;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
public class ActuatorComponent {


    // todo auth control needed
    @WriteOperation
    public void restartServer(){
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.exit(0); // Перезапуск приложения
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }



}
