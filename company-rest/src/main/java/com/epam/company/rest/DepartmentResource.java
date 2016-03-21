package com.epam.company.rest;

import com.epam.company.metadata.*;
import com.epam.company.web.DepartmentServiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import java.util.List;

@Api(value = "Department Resource")
@Path("/departments")
@Produces("application/json")
public class DepartmentResource {

    @Context
    private ResourceContext context;

    @Autowired
    private DepartmentServiceClient client;

    @POST
    @ApiOperation(value = "creates department")
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
}
