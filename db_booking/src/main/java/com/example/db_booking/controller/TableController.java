package com.example.db_booking.controller;

import com.example.db_booking.model.dto.TableDto;
import com.example.db_booking.service.CreateTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
public class TableController {

    private final CreateTableService createTableService;


    @PostMapping("/create-table")
    public String createTable(@RequestBody TableDto tableDto) {

        return createTableService.createTable(tableDto);
    }

/*    @GetMapping("/test")
    public void test(String script, String name) {

        createTableService.writeToFile(script, name);
    }*/

    @GetMapping("/test-2")
    public String testTwo() {

        return null; //createTableService.getFileName("one");

    }

    @GetMapping("/test-3")
    public String testThree() {


        String numberString = "009";
        int number = Integer.parseInt(numberString);
        System.out.println(number);
        number++;
        String formattedNumber = String.format("%03d", number);

        if (formattedNumber.length() > numberString.length()) {
            return formattedNumber;
        } else {
            return numberString;
        }
    }
}
