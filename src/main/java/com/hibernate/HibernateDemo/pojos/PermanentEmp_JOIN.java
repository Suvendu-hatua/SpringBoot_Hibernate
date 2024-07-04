package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "permanent_empJOIN")
@PrimaryKeyJoinColumn(name = "empId")
public class PermanentEmp_JOIN extends  Employee_JOIN{
    @Column(name = "salary")
    private float salary;

    @Column(name = "incentive")
    private  float incentive;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getIncentive() {
        return incentive;
    }

    public void setIncentive(float incentive) {
        this.incentive = incentive;
    }

    @Override
    public String toString() {
        return "PermanentEmp_JOIN{" +
                "salary=" + salary +
                ", incentive=" + incentive +
                '}';
    }
}
