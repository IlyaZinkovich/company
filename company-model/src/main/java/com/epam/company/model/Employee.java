package com.epam.company.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@XmlRootElement(name = "Employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1937049563112345801L;

    @Id
    @GeneratedValue
    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    private Department department;
    @OneToMany(mappedBy = "employee")
    private List<ProjectPosition> projectPositions;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getEmployeeId() != null ? !getEmployeeId().equals(employee.getEmployeeId()) : employee.getEmployeeId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        if (getBirthDate() != null ? !getBirthDate().equals(employee.getBirthDate()) : employee.getBirthDate() != null)
            return false;
        return !(getDepartment() != null ? !getDepartment().equals(employee.getDepartment()) : employee.getDepartment() != null);

    }

    @Override
    public int hashCode() {
        int result = getEmployeeId() != null ? getEmployeeId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        return result;
    }
}
