package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Person;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDaoImp implements PersonDao{
    private EntityManager entityManager;

    @Autowired
    public PersonDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        entityManager.persist(person);
    }
}
