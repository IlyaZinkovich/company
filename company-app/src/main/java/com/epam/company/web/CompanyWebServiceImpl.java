package com.epam.company.web;

import com.epam.company.metadata.*;
import com.epam.company.model.Company;
import com.epam.company.service.CompanyService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CompanyWebServiceImpl implements CompanyWebService {

    @Autowired
    private CompanyService companyService;

    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    static
    {
        mapper.setMappingFiles(Arrays.asList("dozerBeanMapping.xml"));
    }

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
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyDTO> companyDTOs = new ArrayList<>();
        companies.forEach(company -> {
            CompanyDTO companyDTO = new CompanyDTO();
            mapper.map(company, companyDTO);
            companyDTOs.add(companyDTO);
        });
        GetAllCompaniesResponse getAllCompaniesResponse = new GetAllCompaniesResponse();
        companyDTOs.forEach(c -> getAllCompaniesResponse.getReturn().add(c));
        return getAllCompaniesResponse;
    }

    @Override
    public CreateCompanyResponse createCompany(@WebParam(partName = "parameters", name = "createCompanyRequest", targetNamespace = "http://metadata.company.epam.com/") CreateCompanyRequest parameters) {
        CompanyDTO companyDTO = parameters.getArg0();
        Company company = new Company();
        mapper.map(companyDTO, company);
        Long companyId = companyService.createCompany(company);
        CreateCompanyResponse createCompanyResponse = new CreateCompanyResponse();
        createCompanyResponse.setReturn(companyId);
        return createCompanyResponse;
    }
}
