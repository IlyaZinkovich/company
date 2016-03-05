package com.epam.company.service;

import com.epam.company.model.Department;
import com.epam.company.model.Employee;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
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
    private DepartmentService departmentService;

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
    @Ignore
    public void testGetEmployeesByDepartmentId() throws Exception {
        Department department = new Department();
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        List<Employee> employees = Arrays.asList(employee);
        department.setEmployees(employees);
        Long departmentId = departmentService.createDepartment(department);
        assertNotNull(departmentId);
        Department persistedDepartment = departmentService.getDepartmentById(departmentId);
        assertNotNull(persistedDepartment);
        assertNotNull(persistedDepartment.getEmployees());
        List<Employee> employeesByDepartmentId = employeeService.getEmployeesByDepartmentId(departmentId);
        assertNotNull(employeesByDepartmentId);
        assertEquals(1, employeesByDepartmentId.size());
        Employee persistedEmployee = employeesByDepartmentId.get(0);
        assertEquals(employee.getBirthDate(), persistedEmployee.getBirthDate());
    }

}
