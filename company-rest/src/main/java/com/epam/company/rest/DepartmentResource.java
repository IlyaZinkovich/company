package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.DepartmentServiceClient;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@Path("/department")
@Produces("application/json")
public class DepartmentResource {

    @Context
    private ResourceContext context;

    @Autowired
    private DepartmentServiceClient client;

    @POST
    public Long createDepartment(DepartmentDTO departmentDTO) {
        CreateDepartmentRequest request = new CreateDepartmentRequest();
        request.setDepartmentDTO(departmentDTO);
        CreateDepartmentResponse response = client.getDepartmentWebServiceImplPort().createDepartment(request);
        return response.getDepartmentId();
    }

    @GET
    @Path("/{departmentId}")
    public DepartmentDTO getDepartmentById(@PathParam("departmentId") Long departmentId) {
        GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
        request.setDepartmentId(departmentId);
        GetDepartmentByIdResponse response = client.getDepartmentWebServiceImplPort().getDepartmentById(request);
        return  response.getDepartmentDTO();
    }

    @GET
    public List<DepartmentDTO> getAllDepartments() {
        GetAllDepartmentsRequest request = new GetAllDepartmentsRequest();
        GetAllDepartmentsResponse response = client.getDepartmentWebServiceImplPort().getAllDepartments(request);
        return response.getDepartmentDTOList();
    }

    @PUT
    @Path("/{departmentId}")
    public void updateDepartment(@PathParam("departmentId") Long departmentId, DepartmentDTO departmentDTO) {
        departmentDTO.setDepartmentId(departmentId);
        UpdateDepartmentRequest request = new UpdateDepartmentRequest();
        request.setDepartmentDTO(departmentDTO);
        UpdateDepartmentResponse response = client.getDepartmentWebServiceImplPort().updateDepartment(request);
    }

//    @GET
//    @Path("/{departmentId}/employees")
//    public List<EmployeeDTO> getDepartmentEmployees(@PathParam("departmentId") Long departmentId) {
//        EmployeeResource employeeResource = context.getResource(EmployeeResource.class);
//        return employeeResource.getEmployeesByDepartmentId(departmentId);
//    }

    @GET
    @Path("/{departmentId}/employee")
    public List<EmployeeDTO> getDepartmentEmployees(@PathParam("departmentId") Long departmentId) {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new JacksonJaxbJsonProvider());
        WebClient client = WebClient.create("http://localhost:8989/", providers);
        return (List<EmployeeDTO>) client.path("employee").query("departmentId", departmentId)
                .getCollection(EmployeeDTO.class);
    }

    @POST
    @Path("/{departmentId}/employee")
    public void addEmployeesToDepartment(@PathParam("departmentId") Long departmentId, List<EmployeeDTO> employeeDTOs) {
        GetDepartmentByIdRequest request = new GetDepartmentByIdRequest();
        request.setDepartmentId(departmentId);
        GetDepartmentByIdResponse response = client.getDepartmentWebServiceImplPort().getDepartmentById(request);
        DepartmentDTO departmentDTO = response.getDepartmentDTO();
        employeeDTOs.forEach(employeeDTO -> employeeDTO.setDepartment(departmentDTO));
        WebClient client = WebClient.create("http://localhost:8989/");
        client.path("employee").accept("application/json").postCollection(employeeDTOs, EmployeeDTO.class);
    }
}
