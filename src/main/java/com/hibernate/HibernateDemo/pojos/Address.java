package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.stereotype.Component;

@Embeddable
//@Component
public class Address {
    //Defining all the instance variables.
    @Column(name = "city_name",length = 20)
    private String cityName;

    @Column(name = "state",length = 20)
    private String state;

    @Column(name = "pin_num",length = 6)
    private  int pinNumber;

    //Implementing setter and getter methods

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    //Implementing to String method

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", state='" + state + '\'' +
                ", pinNumber=" + pinNumber +
                '}';
    }
}
