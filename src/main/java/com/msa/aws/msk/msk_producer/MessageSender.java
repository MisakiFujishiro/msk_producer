package com.msa.aws.msk.msk_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
public class MessageSender {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topicName = "MSKTutorialTopic";

    @Autowired
    public MessageSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        kafkaTemplate.setDefaultTopic(topicName);
    }

    public void sendMessage(String message) {
        kafkaTemplate.sendDefault(message);
        System.out.println("Message sent: " + message);
    }
}