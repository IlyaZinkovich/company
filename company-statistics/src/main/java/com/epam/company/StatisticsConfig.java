package com.epam.company;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;


@EnableJms
@Configuration
@ComponentScan(basePackages = {"com.epam.company.dao", "com.epam.company.receiver"})
public class StatisticsConfig {

    private static final String JMS_BROKER_URL = "tcp://localhost:61616";
    private static final String MONGO_URI = "mongodb://localhost";
    private static final String DB_NAME = "logs";
    private static final String COLLECTION_NAME = "logs";

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(MONGO_URI));
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return mongoClient().getDatabase(DB_NAME);
    }

    @Bean
    public MongoCollection logsMongoCollection() {
        return mongoDatabase().getCollection(COLLECTION_NAME);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(JMS_BROKER_URL);
        return activeMQConnectionFactory;
    }

    @Bean
    JmsListenerContainerFactory<?> jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

}
