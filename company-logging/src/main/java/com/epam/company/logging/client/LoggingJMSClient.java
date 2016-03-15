package com.epam.company.logging.client;

public interface LoggingJMSClient {
    void sendMessage(String message);
}
