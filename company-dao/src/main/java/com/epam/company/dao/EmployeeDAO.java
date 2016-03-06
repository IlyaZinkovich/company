package com.epam.company.dao;

import com.epam.company.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO {
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    Long createEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getEmployeesByDepartmentId(Long departmentId);
    void updateEmployeesInBatch(List<Employee> employees);
}