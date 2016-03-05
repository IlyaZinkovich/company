package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.EmployeeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.List;

@Path("/employee")
@Produces("application/json")
public class EmployeeResource {

    @Autowired
    private EmployeeServiceClient client;

    @GET
    public List<EmployeeDTO> getAllEmployees() {
        GetAllEmployeesRequest request = new GetAllEmployeesRequest();
        GetAllEmployeesResponse response = client.getEmployeeWebServiceImplPort().getAllEmployees(request);
        return response.getEmployeeDTOList();
    }

    @GET
    public List<EmployeeDTO> getEmployeesByDepartmentId(@PathParam("companyId") Long departmentId) {
        GetEmployeesByDepartmentIdRequest request = new GetEmployeesByDepartmentIdRequest();
        request.setDepartmentId(departmentId);
        GetEmployeesByDepartmentIdResponse response = client.getEmployeeWebServiceImplPort().getEmployeesByDepartmentId(request);
        return response.getEmployeeDTOList();
    }

    @GET
    @Path("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathParam("employeeId") Long employeeId) {
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setEmployeeId(employeeId);
        GetEmployeeByIdResponse response = client.getEmployeeWebServiceImplPort().getEmployeeById(request);
        return response.getEmployeeDTO();
    }

    @POST
    public Long createEmployee(EmployeeDTO employeeDTO) {
        CreateEmployeeRequest request = new CreateEmployeeRequest();
        request.setEmployeeDTO(employeeDTO);
        CreateEmployeeResponse response = client.getEmployeeWebServiceImplPort().createEmployee(request);
        return response.getEmployeeId();
    }

    @PUT
    @Path("/{employeeId}")
    public void updateEmployee(@PathParam("employeeId") Long employeeId, EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeId(employeeId);
        UpdateEmployeeRequest request = new UpdateEmployeeRequest();
        request.setEmployeeDTO(employeeDTO);
        UpdateEmployeeResponse response = client.getEmployeeWebServiceImplPort().updateEmployee(request);
    }
}
