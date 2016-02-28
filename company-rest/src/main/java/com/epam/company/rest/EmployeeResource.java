package com.epam.company.rest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class EmployeeResource {

    @PathParam("companyId")
    private Long companyId;

//    @Autowired
//    private EmployeeService employeeService;
//
//    @Path("/")
//    public List<Employee> getEmployees() {
//        return employeeService.getCompanyEmployees(companyId);
//    }

}
