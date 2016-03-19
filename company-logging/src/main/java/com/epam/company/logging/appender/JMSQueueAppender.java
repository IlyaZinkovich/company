package com.epam.company.logging.appender;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.epam.company.logging.JMSQueueAppenderConfig;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JMSQueueAppender extends AppenderBase<ILoggingEvent> {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private JmsTemplate jmsTemplate;
    private String queue = "queue.logback-queue";
    @Autowired
    private LogstashEncoder encoder;

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
//        if (encoder != null) {
//            try {
//                encoder.doEncode(iLoggingEvent);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        jmsTemplate.convertAndSend(queue, iLoggingEvent.getMessage());
        System.out.println();

    }

    @Override
    public void start() {
        if (encoder != null) {
            encoder.start();
        }
        super.start();
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public void setEncoder(LogstashEncoder encoder) {
        this.encoder = encoder;
    }

    @PostConstruct
    public void postConstruct() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JMSQueueAppender appender = applicationContext.getBean(JMSQueueAppender.class);
        appender.setName("JMSQueueAppender");
        appender.setContext(context);
        appender.start();
//        Logger root = context.getLogger(Logger.ROOT_LOGGER_NAME);
//        Logger cxf = context.getLogger("org.apache.cxf");
//        this.setContext(context);
//        root.addAppender(appender);
//        cxf.addAppender(appender);
    }
}