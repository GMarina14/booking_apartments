package com.example.product_apartment.emailSender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailConfig {
    @Value("${product.mail.host}")
    public final static String HOST = "smtp.yandex.ru";
    public final static String USER_NAME = "marvin1429@yandex.ru";
    public final static String PASSWORD = "bczdlwaztlhhsfxs";

    @Value("${product.mail.port}")
    private int PORT;
    private final static String PROTOCOL = "smtps";
    private final static String DEBAG = "true";

    @Bean
    public JavaMailSender getMailSender() {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(HOST);
        javaMailSender.setUsername(USER_NAME);
        javaMailSender.setPassword(PASSWORD);
        javaMailSender.setPort(PORT);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", PROTOCOL);
        properties.setProperty("mail.debug", DEBAG);

        return javaMailSender;
    }

}
