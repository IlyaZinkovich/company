package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.EmployeeWebServiceImplService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Path("/employee")
@Produces("application/json")
public class EmployeeResource {

    @Autowired
    private EmployeeWebServiceImplService client;

    @GET
    public List<EmployeeDTO> getAllEmployees() {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        GetAllEmployeesResponse response = client.getEmployeeWebServiceImplPort().getAllEmployees(request);
        return response.getReturn();
    }

    @GET
    public List<EmployeeDTO> getEmployeesByCompanyId(@PathParam("companyId") Long companyId) {
        GetEmployeesByCompanyIdRequest request = new GetEmployeesByCompanyIdRequest();
        request.setArg0(companyId);
        GetEmployeesByCompanyIdResponse response = client.getEmployeeWebServiceImplPort().getEmployeesByCompanyId(request);
        return response.getArg0();
    }

    @GET
    @Path("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathParam("employeeId") Long employeeId) {
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setArg0(employeeId);
        GetEmployeeByIdResponse response = client.getEmployeeWebServiceImplPort().getEmployeeById(request);
        return response.getArg0();
    }

    @POST
    public Long createEmployee(EmployeeDTO employeeDTO) {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setArg0(employeeDTO);
        CreateEmployeeResponse response = client.getEmployeeWebServiceImplPort().createEmployee(request);
        return response.getReturn();
    }

    @PUT
    @Path("/{employeeId}")
    public void updateEmployee(@PathParam("employeeId") Long employeeId, EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(employeeId);
        UpdateEmployeeRequest request = new UpdateEmployeeRequest();
        request.setReturn(employeeDTO);
        UpdateEmployeeResponse response = client.getEmployeeWebServiceImplPort().updateEmployee(request);
    }
}
