package com.epam.company.logging;


import com.epam.company.LoggingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoggingApp {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage() {
        jmsTemplate.send("loggingQueue", session -> session.createTextMessage("message"));
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(LoggingConfig.class);
        LoggingApp app = context.getBean(LoggingApp.class);
        app.sendMessage();
    }

}
