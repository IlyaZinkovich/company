package com.epam.company.dao;

import com.epam.company.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e JOIN e.department d WHERE d.id=:departmentId")
    List<Employee> findByDepartmentDepartmentId(@Param("departmentId") Long departmentId);

}
