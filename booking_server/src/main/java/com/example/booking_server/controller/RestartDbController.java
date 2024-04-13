package com.example.booking_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.booking_server.constant.ServerConstants.RESTART_DB;

@RestController
public class RestartDbController {


    @GetMapping(RESTART_DB)
    public void restartDb(){



    }
}
