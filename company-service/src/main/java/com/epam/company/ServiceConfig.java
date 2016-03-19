package com.epam.company;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.epam.company.service")
@Import(DaoConfig.class)
public class ServiceConfig {
}
