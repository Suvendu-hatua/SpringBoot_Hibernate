package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Employee_Pojo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeDaoImp implements EmployeeDao{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addEmployee(Employee_Pojo employeePojo) {
        entityManager.persist(employeePojo);
    }
}
