package com.epam.company;

import com.epam.company.dao.CompanyDAO;
import com.epam.company.model.Company;
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
public class CompanyDAOTest {

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    public void simpleTest() throws Exception {
        Company company = new Company();
        company.setName("company");
        Employee employee = new Employee();
        employee.setBirthDate(LocalDate.now());
        company.getEmployees().add(employee);
        companyDAO.save(company);
        Long id = company.getCompanyId();
        assertNotNull(id);
        Company persistedCompany = companyDAO.findOne(id);
        assertEquals(company.getName(), persistedCompany.getName());
        assertEquals(company.getEmployees(), persistedCompany.getEmployees());
    }
}
