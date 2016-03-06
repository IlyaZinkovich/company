package com.epam.company.dao.impl;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private final int batchSize = 5;

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public Long createEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee.getEmployeeId();
    }

    @Override
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Long departmentId) {
        Query query = entityManager.createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.id=:departmentId");
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }

    @Override
    public void updateEmployeesInBatch(List<Employee> employees) {
        int currentBatchSize = 0;
        for (Employee employee : employees) {
            entityManager.merge(employee);
            currentBatchSize++;
            if (currentBatchSize % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }

}
