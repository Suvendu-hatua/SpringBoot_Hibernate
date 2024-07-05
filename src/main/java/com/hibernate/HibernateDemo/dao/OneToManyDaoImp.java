package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Vendor_Pojo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OneToManyDaoImp implements OneToManyDao{
    private EntityManager entityManager;

    @Autowired
    public OneToManyDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Vendor_Pojo vendorPojo) {
        entityManager.persist(vendorPojo);
    }
}
