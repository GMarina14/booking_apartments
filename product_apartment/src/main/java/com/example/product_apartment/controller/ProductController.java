package com.example.product_apartment.controller;

import com.example.product_apartment.emailSender.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final EmailSender emailSender;

    @GetMapping("/test")
    public String testMethod(@RequestParam Long id) {
        return "product controller " + id;
    }

    @GetMapping("/test2")
    public void testMethod() {
        emailSender.sendEmail("test", "привет", "marika1429@gmail.com");
    }
}
