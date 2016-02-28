package com.epam.company.service.impl;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import com.epam.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee getEmployeeById(Long employeeId) {
        return employeeDAO.getOne(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Long createEmployee(Employee employee) {
        employeeDAO.save(employee);
        return employee.getEmployeeId();
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public List<Employee> getEmployeesByCompanyId(Long companyId) {
        return employeeDAO.findByCompaniesCompanyId(companyId);
    }
}
