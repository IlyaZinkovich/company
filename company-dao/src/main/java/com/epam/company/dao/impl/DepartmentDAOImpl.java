package com.epam.company.dao.impl;

import com.epam.company.dao.DepartmentDAO;
import com.epam.company.model.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department getDepartmentById(Long departmentId) {
        return sessionFactory.getCurrentSession().get(Department.class, departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return sessionFactory.getCurrentSession().createQuery("from Department").list();
    }

    @Override
    public Long createDepartment(Department department) {
        return (Long) sessionFactory.getCurrentSession().save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }
}
