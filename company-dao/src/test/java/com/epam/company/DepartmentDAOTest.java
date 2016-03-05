package com.epam.company;

import com.epam.company.dao.DepartmentDAO;
import com.epam.company.model.Department;
import com.epam.company.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class)
@Transactional
public class DepartmentDAOTest {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Test
    public void simpleTest() throws Exception {
        Department department = new Department();
        department.setName("department");
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        department.getEmployees().add(employee);
        departmentDAO.save(department);
        Long id = department.getDepartmentId();
        assertNotNull(id);
        Department persistedDepartment = departmentDAO.findOne(id);
        assertEquals(department.getName(), persistedDepartment.getName());
        assertEquals(department.getEmployees(), persistedDepartment.getEmployees());
    }
}
