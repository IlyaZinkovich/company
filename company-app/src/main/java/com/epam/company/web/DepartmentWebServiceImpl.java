package com.epam.company.web;

import com.epam.company.metadata.*;
import com.epam.company.model.Department;
import com.epam.company.service.DepartmentService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DepartmentWebServiceImpl implements DepartmentWebService{

    @Autowired
    private DepartmentService departmentService;

    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    static
    {
        mapper.setMappingFiles(Arrays.asList("dozerBeanMapping.xml"));
    }

    @Override
    public UpdateDepartmentResponse updateDepartment(@WebParam(partName = "parameters", name = "updateDepartmentRequest", targetNamespace = "http://metadata.company.epam.com/") UpdateDepartmentRequest parameters) {
        DepartmentDTO departmentDTO = parameters.getDepartmentDTO();
        Department department = new Department();
        mapper.map(departmentDTO, department);
        departmentService.updateDepartment(department);
        return new UpdateDepartmentResponse();
    }

    @Override
    public CreateDepartmentResponse createDepartment(@WebParam(partName = "parameters", name = "createDepartmentRequest", targetNamespace = "http://metadata.company.epam.com/") CreateDepartmentRequest parameters) {
        DepartmentDTO departmentDTO = parameters.getDepartmentDTO();
        Department department = new Department();
        mapper.map(departmentDTO, department);
        Long departmentId = departmentService.createDepartment(department);
        CreateDepartmentResponse createDepartmentResponse = new CreateDepartmentResponse();
        createDepartmentResponse.setDepartmentId(departmentId);
        return createDepartmentResponse;
    }

    @Override
    public GetAllDepartmentsResponse getAllDepartments(@WebParam(partName = "parameters", name = "getAllDepartmentsRequest", targetNamespace = "http://metadata.company.epam.com/") GetAllDepartmentsRequest parameters) {
        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO();
            mapper.map(department, departmentDTO);
            departmentDTOs.add(departmentDTO);
        });
        GetAllDepartmentsResponse getAllDepartmentsResponse = new GetAllDepartmentsResponse();
        departmentDTOs.forEach(departmentDTO -> getAllDepartmentsResponse.getDepartmentDTOList().add(departmentDTO));
        return getAllDepartmentsResponse;
    }

    @Override
    public GetDepartmentByIdResponse getDepartmentById(@WebParam(partName = "parameters", name = "getDepartmentByIdRequest", targetNamespace = "http://metadata.company.epam.com/") GetDepartmentByIdRequest parameters) {
        Long departmentId = parameters.getDepartmentId();
        Department department = departmentService.getDepartmentById(departmentId);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        mapper.map(department, departmentDTO);
        GetDepartmentByIdResponse getDepartmentByIdResponse = new GetDepartmentByIdResponse();
        getDepartmentByIdResponse.setDepartmentDTO(departmentDTO);
        return getDepartmentByIdResponse;
    }
}
