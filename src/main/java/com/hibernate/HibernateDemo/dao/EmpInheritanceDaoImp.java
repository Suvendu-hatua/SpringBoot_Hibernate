package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.ContractEmployee;
import com.hibernate.HibernateDemo.pojos.PermanentEmployee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpInheritanceDaoImp implements EmpInheritanceDao{
    private EntityManager entityManager;
    @Autowired
    public EmpInheritanceDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveContractEmployee(ContractEmployee contractEmployee) {
        entityManager.persist(contractEmployee);
    }

    @Override
    @Transactional
    public void savePermanentEmployee(PermanentEmployee permanentEmployee) {
        entityManager.persist(permanentEmployee);
    }
}
