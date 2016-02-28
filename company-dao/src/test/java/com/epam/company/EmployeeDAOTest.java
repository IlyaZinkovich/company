package com.epam.company;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void simpleTest() throws Exception {
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        employeeDAO.save(employee);
        Long id = employee.getEmployeeId();
        assertNotNull(id);
        Employee persistedEmployee = employeeDAO.findOne(id);
        assertEquals(employee.getBirthDate(), persistedEmployee.getBirthDate());
    }
}
