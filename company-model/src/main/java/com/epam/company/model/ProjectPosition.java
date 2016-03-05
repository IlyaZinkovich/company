package com.epam.company.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@XmlRootElement(name = "ProjectPosition")
public class ProjectPosition {

    @Id
    @GeneratedValue
    private Long projectPositionId;
    private Role role;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(columnDefinition = "employeeId")
    private Employee employee;
    @ManyToOne
    @JoinColumn(columnDefinition = "projectId")
    private Project project;

    public Long getProjectPositionId() {
        return projectPositionId;
    }

    public void setProjectPositionId(Long projectPositionId) {
        this.projectPositionId = projectPositionId;
    }

    private enum Role {
        PROJECT_MANAGER, DEVELOPER, TESTER
    }

    public ProjectPosition() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectPosition)) return false;

        ProjectPosition that = (ProjectPosition) o;

        if (getProjectPositionId() != null ? !getProjectPositionId().equals(that.getProjectPositionId()) : that.getProjectPositionId() != null)
            return false;
        if (getRole() != that.getRole()) return false;
        if (getStartDate() != null ? !getStartDate().equals(that.getStartDate()) : that.getStartDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        if (getEmployee() != null ? !getEmployee().equals(that.getEmployee()) : that.getEmployee() != null)
            return false;
        return !(getProject() != null ? !getProject().equals(that.getProject()) : that.getProject() != null);

    }

    @Override
    public int hashCode() {
        int result = getProjectPositionId() != null ? getProjectPositionId().hashCode() : 0;
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getStartDate() != null ? getStartDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getEmployee() != null ? getEmployee().hashCode() : 0);
        result = 31 * result + (getProject() != null ? getProject().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectPosition{" +
                "projectPositionId=" + projectPositionId +
                ", role=" + role +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", employee=" + employee +
                ", project=" + project +
                '}';
    }
}
