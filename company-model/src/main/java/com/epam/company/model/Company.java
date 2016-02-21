package com.epam.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement(name = "Company")
public class Company implements Serializable {

    private static final long serialVersionUID = -927006435553226472L;

    @Id
    @GeneratedValue
    private Long corporateId;
    private String name;
    private Long employeeCount;
    private String address;
    private String countryCode;
    private String addressLine1;
    private String addressLine2;
    private String cityName;
    private String stateCode;
    private String postalCode;

    public Company() {
    }

    public Long getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(Long corporateId) {
        this.corporateId = corporateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Long employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (getCorporateId() != null ? !getCorporateId().equals(company.getCorporateId()) : company.getCorporateId() != null)
            return false;
        if (getName() != null ? !getName().equals(company.getName()) : company.getName() != null) return false;
        if (getEmployeeCount() != null ? !getEmployeeCount().equals(company.getEmployeeCount()) : company.getEmployeeCount() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(company.getAddress()) : company.getAddress() != null)
            return false;
        if (getCountryCode() != null ? !getCountryCode().equals(company.getCountryCode()) : company.getCountryCode() != null)
            return false;
        if (getAddressLine1() != null ? !getAddressLine1().equals(company.getAddressLine1()) : company.getAddressLine1() != null)
            return false;
        if (getAddressLine2() != null ? !getAddressLine2().equals(company.getAddressLine2()) : company.getAddressLine2() != null)
            return false;
        if (getCityName() != null ? !getCityName().equals(company.getCityName()) : company.getCityName() != null)
            return false;
        if (getStateCode() != null ? !getStateCode().equals(company.getStateCode()) : company.getStateCode() != null)
            return false;
        return !(getPostalCode() != null ? !getPostalCode().equals(company.getPostalCode()) : company.getPostalCode() != null);

    }

    @Override
    public int hashCode() {
        int result = getCorporateId() != null ? getCorporateId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEmployeeCount() != null ? getEmployeeCount().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getCountryCode() != null ? getCountryCode().hashCode() : 0);
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + (getStateCode() != null ? getStateCode().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "corporateId=" + corporateId +
                ", name='" + name + '\'' +
                ", employeeCount=" + employeeCount +
                ", address='" + address + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
