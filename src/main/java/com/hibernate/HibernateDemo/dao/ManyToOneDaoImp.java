package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Department_Pojo;
import com.hibernate.HibernateDemo.pojos.Organization_Pojo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ManyToOneDaoImp implements  ManyToOneDao{

    private EntityManager entityManager;

    @Autowired
    public ManyToOneDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveOrganization(Organization_Pojo organizationPojo) {
        entityManager.persist(organizationPojo);
    }
    @Override
    @Transactional
    public void saveDepartments(Department_Pojo departmentPojo) {
        entityManager.persist(departmentPojo);
    }
}
