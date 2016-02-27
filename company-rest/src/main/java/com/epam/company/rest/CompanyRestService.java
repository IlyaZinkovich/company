package com.epam.company.rest;

import com.epam.company.api.Company;
import com.epam.company.web.CompanyWebServiceImplService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/company")
@Produces("application/json")
public class CompanyRestService {

    @Autowired
    private CompanyWebServiceImplService client;

    @POST
    public Long createCompany(Company company) {
        return client.getCompanyWebServiceImplPort().createCompany(company);
    }

}
