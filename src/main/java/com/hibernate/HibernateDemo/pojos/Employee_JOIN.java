package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_join")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee_JOIN {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name",length = 30)
    private String empName;
    @Column(name = "emp_age",length = 3)
    private int empAge;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee_JOIN{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAge=" + empAge +
                '}';
    }
}
