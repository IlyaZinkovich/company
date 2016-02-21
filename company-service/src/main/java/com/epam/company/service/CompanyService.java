package com.epam.company.service;

import com.epam.company.model.Company;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(Long companyId);
    List<Company> getAllCompanies();
    Long createCompany(Company company);
    void updateCompany(Company company);
}
