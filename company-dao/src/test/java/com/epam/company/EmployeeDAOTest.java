package com.epam.company;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void simpleTest() throws Exception {
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        employeeDAO.createEmployee(employee);
        Long id = employee.getEmployeeId();
        assertNotNull(id);
        Employee persistedEmployee = employeeDAO.getEmployeeById(id);
        assertEquals(employee.getBirthDate(), persistedEmployee.getBirthDate());
    }

    @Test
    public void batchUpdateTest() throws Exception {
        List<Employee> employees = new ArrayList<>();
        int updatedEmployeesSize = 12;
        for (int i = 0; i < updatedEmployeesSize; i++) {
            Employee employee = new Employee();
            employee.setBirthDate(LocalDate.now());
            employees.add(employee);
        }
        employeeDAO.updateEmployeesInBatch(employees);
        List<Employee> updatedEmployees = employeeDAO.getAllEmployees();
        assertEquals(updatedEmployeesSize, updatedEmployees.size());
    }
}
