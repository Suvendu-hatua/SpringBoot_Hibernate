package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    //Returning all the Student Objects from Database.
    //No Transactional annotation ----> cause we are just reading data from database not performing any operations.
    @Override
    public List<Student> findAll() {
        //Create query.
        TypedQuery<Student> query=entityManager.createQuery("from Student",Student.class);
        //Return List<Student> resultList.
        List<Student> studentList=query.getResultList();
        return studentList;
    }

    //Finding specific student by StudentID
    @Override
    public Student findByID(int studentID) {
        Student student=entityManager.find(Student.class,studentID);
        return student;
    }

    //Sorting the whole Student Table By their full name--->by default it's ASC
    @Override
    public List<Student> sortStudentsByName() {
        TypedQuery<Student> studentList= entityManager.createQuery("from Student order by studentName",Student.class);
        return studentList.getResultList();
    }

    //Finding the list of Students by email pattern.
    @Override
    public List<Student> searchByEmail(String emailPattern) {
        TypedQuery<Student> query=entityManager.createQuery("from Student where email like :pattern",Student.class);
        query.setParameter("pattern",emailPattern);
        System.out.println(emailPattern);
        return query.getResultList();
    }

    //Updating specific Student details
    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student student1=entityManager.merge(student);
        return student1;
    }

    //Updating whole Student Table
    @Override
    @Transactional
    public int  updateStudent() {
       int rows= entityManager.createQuery("Update Student set studentName='Suvendu Hatua'").executeUpdate();
       return rows;
    }

    @Override
    @Transactional
    public int deleteStudent(int id) {
      Query query= entityManager.createQuery("delete Student where studentID=:id");
      query.setParameter("id",id);
      int rows=query.executeUpdate();
       return  rows;
    }

    //Deleting all the Students from the Database.
    @Override
    @Transactional
    public int deleteAllStudents() {
        int rows=entityManager.createQuery("delete Student").executeUpdate();
        return rows;
    }


}
