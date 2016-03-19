package com.epam.company.receiver;

import com.epam.company.dao.LoggingDAO;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class LoggingJMSReceiver {

    private static final String QUEUE_NAME = "queue.logback-queue";

    @Autowired
    private LoggingDAO loggingDAO;

    @JmsListener(destination = QUEUE_NAME)
    public void receiveMessage(Message message) throws JMSException {
        String text = ((ActiveMQTextMessage) message).getText();
        System.out.println("Received <" + text + ">");
        loggingDAO.logMessage(text);
    }

}