package com.epam.company.service;

import com.epam.company.model.Company;
import com.epam.company.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @Test
    public void simpleTest() throws Exception {
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        Long id = employeeService.createEmployee(employee);
        assertNotNull(id);
        Employee persistedEmployee = employeeService.getEmployeeById(id);
        assertEquals(employee.getBirthDate(), persistedEmployee.getBirthDate());
    }

    @Test
    public void testGetEmployeesByCompanyId() throws Exception {
        Company company = new Company();
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        List<Employee> employees = Arrays.asList(employee);
        company.setEmployees(employees);
        Long companyId = companyService.createCompany(company);
        assertNotNull(companyId);
        Company persistedCompany = companyService.getCompanyById(companyId);
        assertNotNull(persistedCompany);
        assertNotNull(persistedCompany.getEmployees());
        List<Employee> employeesByCompanyId = employeeService.getEmployeesByCompanyId(companyId);
        assertNotNull(employeesByCompanyId);
        assertEquals(1, employeesByCompanyId.size());
        Employee persistedEmployee = employeesByCompanyId.get(0);
        assertEquals(employee.getBirthDate(), persistedEmployee.getBirthDate());
    }

}
