package com.epam.company.logging.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.epam.company.logging.client.LoggingJMSClient;
import org.springframework.beans.factory.annotation.Autowired;

public class LoggingJMSAppender extends AppenderBase<ILoggingEvent> {

    @Autowired
    private LoggingJMSClient loggingJMSClient;

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        String message = iLoggingEvent.getMessage();
        loggingJMSClient.sendMessage(message);
    }

}
