package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.DepartmentServiceClient;
import com.epam.company.web.EmployeeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.List;

@Path("/department")
@Produces("application/json")
public class DepartmentRestService {

    @Context
    private ResourceContext context;

    @Autowired
    private DepartmentServiceClient departmentServiceClient;
    @Autowired
    private EmployeeServiceClient employeeServiceClient;

    @POST
    public Long createDepartment(DepartmentDTO departmentDTO) {
        CreateDepartmentRequest request = new CreateDepartmentRequest();
        request.setDepartmentDTO(departmentDTO);
        CreateDepartmentResponse response = departmentServiceClient.getDepartmentWebServiceImplPort().createDepartment(request);
        return response.getDepartmentId();
    }

    @GET
    @Path("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathParam("departmentId") Long departmentId) {
        GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
        request.setDepartmentId(departmentId);
        GetDepartmentByIdResponse response = departmentServiceClient.getDepartmentWebServiceImplPort().getDepartmentById(request);
        return  response.getDepartmentDTO();
    }

    @GET
    public List<DepartmentDTO> getAllDepartments() {
        GetAllDepartmentsRequest request = new GetAllDepartmentsRequest();
        GetAllDepartmentsResponse response = departmentServiceClient.getDepartmentWebServiceImplPort().getAllDepartments(request);
        return response.getDepartmentDTOList();
    }

    @PUT
    @Path("/{departmentId}")
    public void updateDepartment(@PathParam("departmentId") Long departmentId, DepartmentDTO departmentDTO) {
        departmentDTO.setDepartmentId(departmentId);
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        request.setDepartmentDTO(departmentDTO);
        UpdateDepartmentResponse response = departmentServiceClient.getDepartmentWebServiceImplPort().updateDepartment(request);
    }

    @GET
    @Path("/{departmentId}/employees")
    public EmployeeResource getDepartmentEmployees() {
        return context.getResource(EmployeeResource.class);
    }

    @POST
    @Path("/{departmentId}/employees")
    public void addEmployeesToDepartment(@PathParam("departmentId") Long departmentId, List<EmployeeDTO> employeeDTOs) {
        GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
        request.setDepartmentId(departmentId);
        GetDepartmentByIdResponse response = departmentServiceClient.getDepartmentWebServiceImplPort().getDepartmentById(request);
        DepartmentDTO departmentDTO = response.getDepartmentDTO();
        employeeDTOs.forEach(employeeDTO -> employeeDTO.setDepartment(departmentDTO));
        UpdateEmployeesInBatchRequest updateRequest = new UpdateEmployeesInBatchRequest();
        updateRequest.getEmployeeDTOs().addAll(employeeDTOs);
        UpdateEmployeesInBatchResponse updateResponse = employeeServiceClient.getEmployeeWebServiceImplPort().updateEmployeesInBatch(updateRequest);
    }

}
