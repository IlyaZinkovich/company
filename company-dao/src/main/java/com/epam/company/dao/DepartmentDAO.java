package com.epam.company.dao;

import com.epam.company.model.Department;

import java.util.List;

public interface DepartmentDAO {
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
    Long createDepartment(Department department);
    void updateDepartment(Department department);
}
