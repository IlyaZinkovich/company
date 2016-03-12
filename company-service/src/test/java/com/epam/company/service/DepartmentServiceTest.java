package com.epam.company.service;

import com.epam.company.model.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void simpleTest() throws Exception {
        Department department = new Department();
        department.setName("department");
        Long id = departmentService.createDepartment(department);
        assertNotNull(id);
        department.setDepartmentId(id);
        Department persistedDepartment = departmentService.getDepartmentById(id);
        assertEquals(department, persistedDepartment);
    }

}
