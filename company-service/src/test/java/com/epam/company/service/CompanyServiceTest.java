package com.epam.company.service;

import com.epam.company.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class CompanyServiceTest {

    @Autowired
    private CompanyService companyService;

    @Test
    public void simpleTest() throws Exception {
        Company company = new Company();
        company.setName("company");
        Long id = companyService.createCompany(company);
        assertNotNull(id);
        company.setCorporateId(id);
        Company persistedCompany = companyService.getCompanyById(id);
        assertEquals(company, persistedCompany);
    }

}
