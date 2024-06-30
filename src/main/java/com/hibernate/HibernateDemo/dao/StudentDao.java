package com.hibernate.HibernateDemo.dao;

import com.hibernate.HibernateDemo.pojos.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);

    public List<Student> findAll();

    public Student findByID(int studentID);

    public List<Student> sortStudentsByName();

    public List<Student> searchByEmail(String emailPattern);
    
    public Student updateStudent(Student student);

    public int updateStudent();

    public int deleteStudent(int id);

    public int deleteAllStudents();
}
