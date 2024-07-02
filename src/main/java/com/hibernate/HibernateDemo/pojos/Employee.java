package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "vwits_empinheritance")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //--> all the subclass will be stored within one table.
@DiscriminatorColumn(name = "EmpType",discriminatorType = DiscriminatorType.STRING,length = 40)
//This is the column that distinguish both the subclasses.
//This is the Parent Class and parent Table also
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",length = 5)
    private int empId;

    @Column(name = "emp_name",length = 30)
    private String empName;

    //Setter and getter methods


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    //Implementing toString() method

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }
}
