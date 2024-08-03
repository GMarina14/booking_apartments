package com.example.product_apartment.controller;

import com.example.product_apartment.emailSender.EmailSender;
import com.example.product_apartment.service.IntegrationService;
import com.example.product_apartment.service.ProductService;
import com.example.product_apartment.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final EmailSender emailSender;
    private final ProductService productService;
    private final SendMessageService sendMessageService;
    private final IntegrationService integrationService;


    @GetMapping("/test")
    public String testMethod(@RequestParam Long id) {
        return "product controller " + id;
    }

    @GetMapping("/test2")
    public void testMethod() {
        emailSender.sendEmail("test", "привет", "marika1429@gmail.com");
    }

    @GetMapping("/get-discount")
    public void getDiscountAndSendMessage(@RequestParam Long id, @RequestHeader String token) {

        //todo валидация токена
        if (integrationService.checkValidToken(token).isPresent()) {
            productService.getDiscount(id);
            sendMessageService.sendMessage(id);
        }
    }


}
