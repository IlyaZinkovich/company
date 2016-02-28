package com.epam.company.web;

import com.epam.company.metadata.*;
import com.epam.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;

@Component
public class CompanyWebServiceImpl implements CompanyWebService {

    @Autowired
    private CompanyService companyService;

    @Override
    public UpdateCompanyResponse updateCompany(@WebParam(partName = "parameters", name = "updateCompanyRequest", targetNamespace = "http://metadata.company.epam.com/") UpdateCompanyRequest parameters) {
        return null;
    }

    @Override
    public GetCompanyByIdResponse getCompanyById(@WebParam(partName = "parameters", name = "getCompanyByIdRequest", targetNamespace = "http://metadata.company.epam.com/") GetCompanyByIdRequest parameters) {
        return null;
    }

    @Override
    public GetAllCompaniesResponse getAllCompanies(@WebParam(partName = "parameters", name = "getAllCompaniesRequest", targetNamespace = "http://metadata.company.epam.com/") GetAllCompaniesRequest parameters) {
        return null;
    }

    @Override
    public CreateCompanyResponse createCompany(@WebParam(partName = "parameters", name = "createCompanyRequest", targetNamespace = "http://metadata.company.epam.com/") CreateCompanyRequest parameters) {
        return null;
    }
}
