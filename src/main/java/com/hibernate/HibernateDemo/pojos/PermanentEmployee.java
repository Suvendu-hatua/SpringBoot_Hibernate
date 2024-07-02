package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//SubClass of Employee
@Entity
@DiscriminatorValue(value = "Permanent_Employee")
public class PermanentEmployee extends Employee{
    @Column(name = "salary")
    private float salary;

    @Column(name = "incentive")
    private float incentive;

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
        return "PermanentEmployee{" +
                "salary=" + salary +
                ", incentive=" + incentive +
                '}';
    }
}
