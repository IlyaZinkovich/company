package com.epam.company.logging.client.impl;

import com.epam.company.logging.client.LoggingJMSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingJMSClientImpl implements LoggingJMSClient {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        jmsTemplate.send("loggingQueue", session -> session.createTextMessage(message));
    }
}
