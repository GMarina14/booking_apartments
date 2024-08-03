package com.example.product_apartment.scheduler;

import com.example.product_apartment.config.ConsumerListenerTopic;
import com.example.product_apartment.model.BookingInfoEntity;
import com.example.product_apartment.repository.BookingInfoRepository;
import com.example.product_apartment.service.ProductService;
import com.example.product_apartment.service.SendMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class productScheduler {

    private final ProductService productService;
    private final ConsumerListenerTopic consumerListenerTopic;
    private final BookingInfoRepository bookingInfoRepository;
    private final SendMessageService sendMessageService;


    /**
     * The method checks if there are any missed messages
     * if there are any, discount is calculated and user gets an email, containing details of the booking
     */
    @Scheduled(fixedDelay = 60000L)
    public void checkBookingInfo() {
        log.info("Scheduler is starting");
        List<String> messages = consumerListenerTopic.getMessages();
        if (!messages.isEmpty()) {
            for (String s : messages) {

                Long bookingId = bookingInfoRepository.findBookingInfoEntityById(Long.valueOf((s))).getId();
                productService.getDiscount(bookingId);
                sendMessageService.sendMessage(bookingId);
            }
        }
    }

}
