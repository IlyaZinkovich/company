package com.epam.company;

import com.epam.company.filter.SupportCORSFilter;
import com.epam.company.rest.DepartmentResource;
import com.epam.company.rest.EmployeeResource;
import com.epam.company.web.DepartmentServiceClient;
import com.epam.company.web.EmployeeServiceClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.validation.BeanValidationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan(basePackages = "com.epam.company")
public class RestAppConfig
{

    @Bean(destroyMethod = "destroy")
    public Server server()
    {
        JAXRSServerFactoryBean factory = serverFactoryBean();
        factory.setBus(cxf());
        return factory.create();
    }

    @Bean
    public JAXRSServerFactoryBean serverFactoryBean()
    {
        JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(new Application(),
                JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.asList(departmentResource(), employeeResource()));
        factory.setProviders(Arrays.asList(jsonProvider(), supportCORSFilter()));
        factory.setFeatures(asList(beanValidationFeature()));
        return factory;
    }

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf()
    {
        SpringBus bus = new SpringBus();
        bus.getInInterceptors().add(new LoggingInInterceptor());
        bus.getOutInterceptors().add(new LoggingOutInterceptor());
        return bus;
    }

    @Bean
    public JacksonJsonProvider jsonProvider()
    {
        return new JacksonJsonProvider(objectMapper());
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new JaxbAnnotationModule().setPriority(JaxbAnnotationModule.Priority.SECONDARY));
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

    @Bean
    public DepartmentServiceClient departmentClient() {
        return new DepartmentServiceClient();
    }

    @Bean
    public EmployeeServiceClient employeeClient() {
        return new EmployeeServiceClient();
    }

    @Bean
    public DepartmentResource departmentResource() {
        return new DepartmentResource();
    }

    @Bean
    public EmployeeResource employeeResource() {
        return new EmployeeResource();
    }

    @Bean
    public SupportCORSFilter supportCORSFilter()
    {
        return new SupportCORSFilter();
    }

    @Bean
    public BeanValidationFeature beanValidationFeature()
    {
        return new BeanValidationFeature();
    }

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
