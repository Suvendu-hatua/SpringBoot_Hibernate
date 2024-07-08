package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vwits_organization")
public class Organization_Pojo {
    @Id
    @Column(name = "org_id")
    private int orgId;

    @Column(name = "org_name",length = 50)
    private String orgName;


    @Column(name = "org_location",length = 30)
    private String orgLocation;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "organization")
    private List<Department_Pojo> departments=new ArrayList<>();

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgLocation() {
        return orgLocation;
    }

    public void setOrgLocation(String orgLocation) {
        this.orgLocation = orgLocation;
    }
    public List<Department_Pojo> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department_Pojo> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Organization_Pojo{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", orgLocation='" + orgLocation + '\'' +
                '}';
    }
}
