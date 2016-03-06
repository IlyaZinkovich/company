package com.epam.company.service.impl;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import com.epam.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee getEmployeeById(Long employeeId) {
        return employeeDAO.getEmployeeById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Long createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
        return employee.getEmployeeId();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        return employeeDAO.getEmployeesByDepartmentId(departmentId);
    }

    @Override
    public void updateEmployeesInBatch(List<Employee> employees) {
        employeeDAO.updateEmployeesInBatch(employees);
    }
}
