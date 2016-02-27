package com.epam.company;

import com.epam.company.api.CompanyWebService;
import com.epam.company.web.CompanyWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
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
    private CompanyWebService companyWebService;

    @Bean
    public Endpoint companyWebService() {
        EndpointImpl endpoint = new EndpointImpl(bus, companyWebService);
        endpoint.publish("/");
        return endpoint;
    }

}
