package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.CompanyWebServiceImplService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@Path("/company")
@Produces("application/json")
public class CompanyRestService {

    @Context
    private ResourceContext context;

    @Autowired
    private CompanyWebServiceImplService client;

    @POST
    public Long createCompany(CompanyDTO companyDTO) {
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setArg0(companyDTO);
        CreateCompanyResponse response = client.getCompanyWebServiceImplPort().createCompany(request);
        return response.getReturn();
    }

    @GET
    @Path("/{companyId}")
    public CompanyDTO getCompanyById(@PathParam("companyId") Long companyId) {
        GetCompanyByIdRequest request = new GetCompanyByIdRequest();
        request.setArg0(companyId);
        GetCompanyByIdResponse response = client.getCompanyWebServiceImplPort().getCompanyById(request);
        return  response.getArg0();
    }

    @GET
    public List<CompanyDTO> getAllCompanies() {
        GetAllCompaniesRequest request = new GetAllCompaniesRequest();
        GetAllCompaniesResponse response = client.getCompanyWebServiceImplPort().getAllCompanies(request);
        return response.getReturn();
    }

    @PUT
    @Path("/{companyId}")
    public void updateCompany(@PathParam("companyId") Long companyId, CompanyDTO companyDTO) {
        companyDTO.setCompanyId(companyId);
        UpdateCompanyRequest request = new UpdateCompanyRequest();
        request.setReturn(companyDTO);
        UpdateCompanyResponse response = client.getCompanyWebServiceImplPort().updateCompany(request);
    }

    @Path("/{companyId}/employees")
    public EmployeeResource getCompanyEmployees() {
        return context.getResource(EmployeeResource.class);
    }

}
