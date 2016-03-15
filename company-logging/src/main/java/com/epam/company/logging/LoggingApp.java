package com.epam.company.logging;


import com.epam.company.LoggingConfig;
import com.epam.company.logging.client.LoggingJMSClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggingApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LoggingConfig.class);
        LoggingJMSClient app = context.getBean(LoggingJMSClient.class);
        app.sendMessage("logMessage");
    }

}
