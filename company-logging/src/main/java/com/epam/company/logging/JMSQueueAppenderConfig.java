package com.epam.company.logging;

import net.logstash.logback.encoder.LogstashEncoder;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@ComponentScan(basePackages = "com.epam.company.logging.appender")
public class JMSQueueAppenderConfig {

    private static final String JMS_BROKER_URL = "tcp://localhost:61616";

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }

    @Bean
    public LogstashEncoder logstashEncoder() {
        return new LogstashEncoder();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(JMS_BROKER_URL);
        return activeMQConnectionFactory;
    }
}
