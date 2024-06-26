package com.hibernate.HibernateDemo.pojos;

import jakarta.persistence.*;


@Entity
@Table(name="vwits_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int studentID;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "email")
    private String email;

    //Parameterized constructor for initializing variables.
    public Student(){

    }
    public Student(String studentName, String email) {
        this.studentName = studentName;
        this.email = email;
    }
    //Setter and getter methods for setting up and getting values
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString() method for printing purpose

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
