package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="contract_empJOIN")
@PrimaryKeyJoinColumn(name = "empId")
public class ContractEmp_JOIN extends Employee_JOIN {
    @Column(name = "day_salary")
    private float perDaySalary;

    @Column(length = 3)
    private int duration;

    public float getPerDaySalary() {
        return perDaySalary;
    }

    public void setPerDaySalary(float perDaySalary) {
        this.perDaySalary = perDaySalary;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ContractEmp_JOIN{" +
                "perDaySalary=" + perDaySalary +
                ", duration=" + duration +
                '}';
    }
}
