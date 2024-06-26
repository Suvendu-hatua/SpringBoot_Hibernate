package com.hibernate.HibernateDemo;

import com.hibernate.HibernateDemo.dao.StudentDao;
import com.hibernate.HibernateDemo.pojos.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.hibernate.HibernateDemo.*"})
public class HibernateDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
			createStudent(studentDao);
		};
	}
	private static void createStudent(StudentDao studentDao){
		//Create the Student Object.
		System.out.println("Creating new Student Object.....");
		Student student=new Student("Akash Kumar","akash2001@gmail.com");

		//Saving the Student Object.
		studentDao.save(student);
		System.out.println("Student object is saved successfully.");

		//Display the Id of the saved student.
		System.out.println("Generated Student_ID: "+student.getStudentID());
	}


}
