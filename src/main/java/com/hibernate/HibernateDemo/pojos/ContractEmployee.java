package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Contract_Employee")
public class ContractEmployee extends Employee{
    @Column(name = "perday_salary")
    private float perDaySalary;

    @Column(name = "duration_day",length = 3)
    private int durationDay;

    public float getPerDaySalary() {
        return perDaySalary;
    }

    public void setPerDaySalary(float perDaySalary) {
        this.perDaySalary = perDaySalary;
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "perDaySalary=" + perDaySalary +
                ", durationDay=" + durationDay +
                '}';
    }
}
