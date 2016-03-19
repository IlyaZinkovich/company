package com.epam.company;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LoggingApp {

    public static void main(String[] args) {
        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
        ApplicationContext context = new AnnotationConfigApplicationContext(StatisticsConfig.class);
    }

}
