package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vwits_employee")
public class Employee_Pojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id",length = 10)
    private int empId;

    @Column(name = "first_name",length = 20)
    private String firstName;

    @Column(name = "last_name",length = 20)
    private String lastName;

    @Column(name = "employee_email",length = 30)
    private String empEmail;

    @ElementCollection  //This annotation is used to store Collection of data like
    // (Set, List,Map etc) but as a separate table in database.
    @JoinTable(name="vwits_address")
    Set<Address> addresses=new HashSet<>();

    //Implementing Setter and Getter methods.

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    //Implementing toString() method

    @Override
    public String toString() {
        return "Employee_Pojo{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
