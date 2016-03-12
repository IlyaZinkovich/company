package com.epam.company.service;


import com.epam.company.model.Employee;
import com.epam.company.model.EmployeeCriteria;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    Long createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getEmployeesMatchingCriteria(EmployeeCriteria employeeCriteria);
    void updateEmployeesInBatch(List<Employee> employees);
}
