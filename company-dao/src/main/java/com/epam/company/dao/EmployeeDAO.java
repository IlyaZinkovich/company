package com.epam.company.dao;

import com.epam.company.model.Employee;
import com.epam.company.model.EmployeeCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    Long createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getEmployeesMatchingCriteria(EmployeeCriteria employeeCriteria);
    void updateEmployeesInBatch(List<Employee> employees);
}