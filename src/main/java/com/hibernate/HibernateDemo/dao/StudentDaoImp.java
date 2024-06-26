package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImp implements StudentDao{
    //Define field for EntityManager
    private EntityManager entityManager;

    //Inject EntityManager using Constructor injection.
    @Autowired
    public StudentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implement the save() method.
    @Override
    @Transactional //performing transaction on database---->saving data.
    public void save(Student student) {
        try{
            entityManager.persist(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
