package com.epam.company.service;

import com.epam.company.model.Department;

import java.util.List;

public interface DepartmentService {
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
    Long createDepartment(Department department);
    void updateDepartment(Department department);
}
