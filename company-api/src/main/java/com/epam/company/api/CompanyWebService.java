package com.epam.company.api;

import com.epam.company.model.Company;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CompanyWebService {

    @WebMethod
    Long createCompany(Company company);
}
