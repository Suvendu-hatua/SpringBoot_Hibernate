package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "vwits_customer")
public class Customer_Pojo {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerID;

    @Column(name = "customer_name",length = 30)
    private String customerName;

    @Column(name="customer_email",length = 30)
    private String customerEmail;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "Customer_Pojo{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
