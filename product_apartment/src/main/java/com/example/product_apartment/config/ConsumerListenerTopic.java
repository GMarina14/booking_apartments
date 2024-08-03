package com.example.product_apartment.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConsumerListenerTopic {

    private final String TOPIC_POST_PROCESSING = "topic_post_processing";
    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = TOPIC_POST_PROCESSING, groupId = "kafka-sandbox")
    public void listen(String message){

        synchronized (messages){
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}
