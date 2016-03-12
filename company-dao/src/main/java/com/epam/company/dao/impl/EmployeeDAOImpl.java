package com.epam.company.dao.impl;

import com.epam.company.dao.EmployeeDAO;
import com.epam.company.model.Employee;
import com.epam.company.model.EmployeeCriteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private final int batchSize = 5;

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return sessionFactory.getCurrentSession().get(Employee.class, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    @Override
    public Long createEmployee(Employee employee) {
        return (Long) sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public List<Employee> getEmployeesMatchingCriteria(EmployeeCriteria employeeCriteria) {
        return sessionFactory.getCurrentSession().createCriteria(Employee.class)
                .add(Restrictions.eq("department.departmentId", employeeCriteria.getDepartmentId()))
                .add(Restrictions.eq("email", employeeCriteria.getEmail()))
                .add(Restrictions.eq("firstName", employeeCriteria.getFirstName()))
                .add(Restrictions.eq("lastName", employeeCriteria.getLastName()))
                .add(Restrictions.eq("location", employeeCriteria.getLocation()))
                .setFirstResult(employeeCriteria.getSkip())
                .setMaxResults(employeeCriteria.getLimit())
                .list();
    }

    @Override
    public void updateEmployeesInBatch(List<Employee> employees) {
        int currentBatchSize = 0;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (Employee employee : employees) {
            session.saveOrUpdate(employee);
            currentBatchSize++;
            if (currentBatchSize % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close();
    }

}
