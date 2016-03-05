package com.epam.company;

import com.epam.company.metadata.DepartmentWebService;
import com.epam.company.metadata.EmployeeWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.xml.ws.Endpoint;

@Configuration
@ImportResource(locations = {"classpath:META-INF/cxf/cxf.xml",
        "classpath:META-INF/cxf/cxf-servlet.xml"})
@ComponentScan("com.epam.company")
public class AppConfig {

    @Autowired
    private Bus bus;
    @Autowired
    private DepartmentWebService departmentWebService;
    @Autowired
    private EmployeeWebService employeeWebService;

    @Bean
    public Endpoint companyWebService() {
        EndpointImpl endpoint = new EndpointImpl(bus, departmentWebService);
        endpoint.publish("/DepartmentWebService");
        return endpoint;
    }

    @Bean
    public Endpoint employeeWebService() {
        EndpointImpl endpoint = new EndpointImpl(bus, employeeWebService);
        endpoint.publish("/EmployeeWebService");
        return endpoint;
    }

}
