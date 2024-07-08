package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

@Entity
@Table(name ="vwits_department")
public class Department_Pojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptID;

    @Column(name = "dept_name",length = 30)
    private String deptName;

    //**************************************ManyToOne Relationship ****************************
    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "org_Id")
    private Organization_Pojo organization;

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Organization_Pojo getOrganization() {
        return organization;
    }

    public void setOrganization(Organization_Pojo organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Department_Pojo{" +
                "deptID=" + deptID +
                ", deptName='" + deptName + '\'' +
                ", organization=" + organization +
                '}';
    }
}
