package com.epam.company.service.impl;

import com.epam.company.dao.CompanyDAO;
import com.epam.company.model.Company;
import com.epam.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public Company getCompanyById(Long companyId) {
        return companyDAO.findOne(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }

    @Override
    public Long createCompany(Company company) {
        companyDAO.save(company);
        return company.getCompanyId();
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.save(company);
    }
}
