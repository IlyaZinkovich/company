package com.epam.company.logging.appender;


import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class LoggingJMSAppender extends AppenderBase<ILoggingEvent> {

    private PatternLayoutEncoder encoder;

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {

    }

    public PatternLayoutEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PatternLayoutEncoder encoder) {
        this.encoder = encoder;
    }
}
