package com.epam.company.web;

import com.epam.company.api.CompanyWebService;
import com.epam.company.model.Company;
import com.epam.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyWebServiceImpl implements CompanyWebService {

    @Autowired
    private CompanyService companyService;

    @Override
    public Long createCompany(Company company) {
        return companyService.createCompany(company);
    }

}
