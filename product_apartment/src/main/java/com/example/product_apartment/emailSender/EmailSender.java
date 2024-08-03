package com.example.product_apartment.emailSender;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Configuration
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender javaMailSender;

    public void sendEmail(String subject, String text, String receiver) {

        SimpleMailMessage simpleMail = new SimpleMailMessage();
        simpleMail.setFrom(JavaMailConfig.USER_NAME);
        simpleMail.setTo(receiver);
        simpleMail.setSubject(subject);
        simpleMail.setText(text);
        javaMailSender.send(simpleMail);

    }
}
