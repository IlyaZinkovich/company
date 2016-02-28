package com.epam.company.web;

import com.epam.company.metadata.*;
import org.springframework.stereotype.Component;

import javax.jws.WebParam;
import javax.xml.ws.Holder;

@Component
public class EmployeeWebServiceImpl implements EmployeeWebService {

    @Override
    public GetEmployeeByIdResponse getEmployeeById(@WebParam(partName = "parameters", name = "getEmployeeByIdRequest", targetNamespace = "http://metadata.company.epam.com/") GetEmployeeByIdRequest parameters) {
        return null;
    }

    @Override
    public void getEmployeesByCompanyId(@WebParam(partName = "parameters", mode = WebParam.Mode.INOUT, name = "getEmployeesByCompanyIdRequest", targetNamespace = "http://metadata.company.epam.com/") Holder<GetEmployeesByCompanyIdRequest> parameters) {

    }

    @Override
    public CreateEmployeeResponse createEmployee(@WebParam(partName = "parameters", name = "createEmployeeRequest", targetNamespace = "http://metadata.company.epam.com/") CreateEmployeeRequest parameters) {
        return null;
    }

    @Override
    public GetAllEmployeesResponse getAllEmployees(@WebParam(partName = "parameters", name = "getAllEmployeesRequest", targetNamespace = "http://metadata.company.epam.com/") GetAllEmployeesRequest parameters) {
        return null;
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(@WebParam(partName = "parameters", name = "updateEmployeeRequest", targetNamespace = "http://metadata.company.epam.com/") UpdateEmployeeRequest parameters) {
        return null;
    }

}
