package com.example.db_booking.controller;

import com.example.db_booking.component.ActuatorComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.db_booking.constant.DbConstants.RESTART_SERVER;

@RestController
@RequiredArgsConstructor
public class RestartServer {

    private final ActuatorComponent actuatorComponent;


    @PostMapping("/test-actuator")
    public void restartServer(){
         actuatorComponent.restartServer();
    }
}
