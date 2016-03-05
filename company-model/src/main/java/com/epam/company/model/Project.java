package com.epam.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement(name = "Project")
public class Project implements Serializable {

    private static final long serialVersionUID = -9057494089481245933L;

    @Id
    @GeneratedValue
    private Long projectId;
    private String projectName;
    private String customer;
    @OneToMany(mappedBy = "project")
    private List<ProjectPosition> projectPositions;

    public Project() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
