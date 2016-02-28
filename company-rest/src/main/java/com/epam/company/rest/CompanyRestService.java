package com.epam.company.rest;

import com.epam.company.web.CompanyWebServiceImplService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.ArrayList;

@Path("/company")
@Produces("application/json")
public class CompanyRestService {

    @Context
    private ResourceContext context;

    @Autowired
    private CompanyWebServiceImplService client;

//    @POST
//    public Long createCompany(Company company) {
//        return client.getCompanyWebServiceImplPort().createCompany(company);
//    }

    @Path("/{id}/employees")
    public EmployeeResource getCompanyEmployees() {
        return context.getResource(EmployeeResource.class);
    }

}
