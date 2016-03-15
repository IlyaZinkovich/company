package com.epam.company.logging;

import com.epam.company.logging.dao.LoggingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LoggingJMSReceiver {

    @Autowired
    private LoggingDAO loggingDAO;

    @JmsListener(destination = "loggingQueue", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        loggingDAO.logMessage(message);
    }

}