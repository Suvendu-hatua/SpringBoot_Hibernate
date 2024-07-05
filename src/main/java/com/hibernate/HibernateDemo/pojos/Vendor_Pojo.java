package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "vwits_vendor")
public class Vendor_Pojo {
    //OneToMany Relationship
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_id")
    private  int vendorId;

    @Column(name = "vendor_name",length = 30)
    private String vendorName;

    @OneToMany(targetEntity = Customer_Pojo.class,cascade =CascadeType.ALL)
    @JoinColumn(name = "vendorFor_id",referencedColumnName = "vendor_id")
   private Set<Customer_Pojo> customers;

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Set<Customer_Pojo> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer_Pojo> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Vendor_Pojo{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", customers=" + customers +
                '}';
    }
}
