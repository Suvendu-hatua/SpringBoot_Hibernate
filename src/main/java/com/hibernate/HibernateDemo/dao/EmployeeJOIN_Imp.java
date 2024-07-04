package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.ContractEmp_JOIN;
import com.hibernate.HibernateDemo.pojos.PermanentEmp_JOIN;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeJOIN_Imp implements EmployeeJOINDao{
    private EntityManager entityManager;

    @Autowired
    public EmployeeJOIN_Imp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void savePermanentEmp(PermanentEmp_JOIN emp1) {
        entityManager.persist(emp1);
    }

    @Override
    @Transactional
    public void saveContractEmp(ContractEmp_JOIN emp2) {
        entityManager.persist(emp2);
    }
}
