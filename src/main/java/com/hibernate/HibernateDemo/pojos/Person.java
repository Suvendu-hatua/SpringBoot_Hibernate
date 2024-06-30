package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "vwits_person")
public class Person {
    //Defining all the instance variables.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int personId;

    @Column(name = "person_name",length = 50)
    private String personName;

    @Column(name = "person_email",length = 50)
    private String personEmail;

    @Embedded //This annotation is used for embedding Address pojo as a
    //component in Person pojo class.
    private Address address;

    //Implementing setter and getter methods

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    //Implementing toString() method for printing the object.

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", address=" + address +
                '}';
    }
}
