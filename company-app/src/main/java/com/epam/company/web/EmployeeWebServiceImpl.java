package com.epam.company.web;

import com.epam.company.metadata.*;
import com.epam.company.model.Employee;
import com.epam.company.service.EmployeeService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeWebServiceImpl implements EmployeeWebService {

    @Autowired
    private EmployeeService employeeService;

    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    static {
        mapper.setMappingFiles(Arrays.asList("dozerBeanMapping.xml"));
    }

    @Override
    public GetEmployeeByIdResponse getEmployeeById(@WebParam(partName = "parameters", name = "getEmployeeByIdRequest", targetNamespace = "http://metadata.company.epam.com/") GetEmployeeByIdRequest parameters) {
        Long employeeId = parameters.getEmployeeId();
        Employee employee = employeeService.getEmployeeById(employeeId);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        mapper.map(employee, employeeDTO);
        GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
        response.setEmployeeDTO(employeeDTO);
        return response;
    }

    @Override
    public CreateEmployeeResponse createEmployee(@WebParam(partName = "parameters", name = "createEmployeeRequest", targetNamespace = "http://metadata.company.epam.com/") CreateEmployeeRequest parameters) {
        EmployeeDTO employeeDTO = parameters.getEmployeeDTO();
        Employee employee = new Employee();
        mapper.map(employeeDTO, employee);
        Long employeeId = employeeService.createEmployee(employee);
        CreateEmployeeResponse response = new CreateEmployeeResponse();
        response.setEmployeeId(employeeId);
        return response;
    }

    @Override
    public UpdateEmployeesInBatchResponse updateEmployeesInBatch(@WebParam(partName = "parameters", name = "updateEmployeesInBatchRequest", targetNamespace = "http://metadata.company.epam.com/") UpdateEmployeesInBatchRequest parameters) {
        List<EmployeeDTO> employeeDTOs = parameters.getEmployeeDTOs();
        List<Employee> employees = new ArrayList<>();
        employeeDTOs.forEach(employeeDTO -> {
            Employee employee = new Employee();
            mapper.map(employeeDTO, employee);
            employees.add(employee);
        });
        employeeService.updateEmployeesInBatch(employees);
        UpdateEmployeesInBatchResponse response = new UpdateEmployeesInBatchResponse();
        return response;
    }

    @Override
    public GetAllEmployeesResponse getAllEmployees(@WebParam(partName = "parameters", name = "getAllEmployeesRequest", targetNamespace = "http://metadata.company.epam.com/") GetAllEmployeesRequest parameters) {
        List<Employee> employees = employeeService.getAllEmployees();
        GetAllEmployeesResponse response = new GetAllEmployeesResponse();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            mapper.map(employee, employeeDTO);
            response.getEmployeeDTOList().add(employeeDTO);
        });
        return response;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(@WebParam(partName = "parameters", name = "updateEmployeeRequest", targetNamespace = "http://metadata.company.epam.com/") UpdateEmployeeRequest parameters) {
        EmployeeDTO employeeDTO = parameters.getEmployeeDTO();
        Employee employee = new Employee();
        mapper.map(employeeDTO, employee);
        employeeService.updateEmployee(employee);
        return new UpdateEmployeeResponse();
    }

    @Override
    public GetEmployeesByDepartmentIdResponse getEmployeesByDepartmentId(@WebParam(partName = "parameters", name = "getEmployeesByDepartmentIdRequest", targetNamespace = "http://metadata.company.epam.com/") GetEmployeesByDepartmentIdRequest parameters) {
        Long departmentId = parameters.getDepartmentId();
        List<Employee> employees = employeeService.getEmployeesByDepartmentId(departmentId);
        GetEmployeesByDepartmentIdResponse response = new GetEmployeesByDepartmentIdResponse();
        employees.forEach(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            mapper.map(employee, employeeDTO);
            response.getEmployeeDTOList().add(employeeDTO);
        });
        return response;
    }

}
