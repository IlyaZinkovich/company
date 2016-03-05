package com.epam.company.service.impl;

import com.epam.company.dao.DepartmentDAO;
import com.epam.company.model.Department;
import com.epam.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentDAO.findOne(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    @Override
    public Long createDepartment(Department department) {
        departmentDAO.save(department);
        return department.getDepartmentId();
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.save(department);
    }
}
