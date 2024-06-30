package com.hibernate.HibernateDemo;

import com.hibernate.HibernateDemo.dao.PersonDao;
import com.hibernate.HibernateDemo.dao.StudentDao;
import com.hibernate.HibernateDemo.pojos.Address;
import com.hibernate.HibernateDemo.pojos.Person;
import com.hibernate.HibernateDemo.pojos.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.hibernate.HibernateDemo.*"})
public class HibernateDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao,PersonDao personDao){
		return runner->{
			//Methods for StudentDao
//			createStudent(studentDao);
//			readStudentById(studentDao);
//			displayStudentsByName(studentDao);
//			searchByEmail(studentDao);
//			updateStudent(studentDao);
//			updateWholeTable(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudents(studentDao);

			//Methods for PersonDao
			addPerson(personDao);
		};
	}

	private void addPerson(PersonDao personDao){
		//Creating person instance
		Person person=new Person();
		person.setPersonName("Sonali Hatua");
		person.setPersonEmail("sonali@gmail.com");
		//Creating Address instance;
		Address address=new Address();
		address.setCityName("Kharagpur");
		address.setState("West Bengal");
		address.setPinNumber(721152);

		//Embedding address to person object.
		person.setAddress(address);

		//Calling addPerson() method of PersonDao interface.
		personDao.addPerson(person);
		System.out.println("Person is added successfully....");
		System.out.println("Person Id:"+person.getPersonId());
	}

	private void deleteAllStudents(StudentDao studentDao){
		int rows=studentDao.deleteAllStudents();
		System.out.println("***********************************************************");
		System.out.println("Deleting all the Students from Database.....");
		System.out.println("Deleted "+rows+" successfully.");
	}

	private void deleteStudent(StudentDao studentDao){
		//Deleting the specific Student from database using Student Id.
		int rows=studentDao.deleteStudent(1);
		System.out.println("****************************************************************");
		System.out.println("Deleted "+rows+" successfully from Database.");
	}

	private void updateWholeTable(StudentDao studentDao){
		System.out.println("*****************************************************");
		System.out.println("Updating whole Database Table.......");
		int rows=studentDao.updateStudent();
		System.out.println("Updated "+rows+" rows successfully.");
	}

	private void updateStudent(StudentDao studentDao){
		//Finding the Student object by using studentID from Database.
		Student student=studentDao.findByID(2);
		//Updating Student details.
		student.setEmail("update2024@gmail.com");
		//Calling the updateStudent method to update details in the Database.
		Student updatedStudent=studentDao.updateStudent(student);
		System.out.println("******************************** Updated Student Details *******************");
		System.out.println(updatedStudent);

	}

	private void searchByEmail(StudentDao studentDao){
		List<Student> list=studentDao.searchByEmail("%2001@gmail.com");
		System.out.println("***************************************************************");
		System.out.println("Displaying Students by email address pattern..");
		for(Student student:list){
			System.out.println(student);
		}
	}

	private void displayStudentsByName(StudentDao studentDao){
		List<Student> studentList=studentDao.sortStudentsByName();
		System.out.println("******************************************************************");
		System.out.println("Displaying Student Details by their name....");
		for(Student student:studentList)
		{
			System.out.println(student);
		}
	}

	private void readStudentById(StudentDao studentDao){
		Student student=studentDao.findByID(1);
		System.out.println("******************************************************************");
		System.out.println("Retrieving Student info whose id=1....");
		System.out.println(student);
	}

	private void readAllStudents(StudentDao studentDao) {
		//call the findAll() method
		List<Student> studentList =studentDao.findAll();
		//Display the students one by one.
		System.out.println("Displaying all the Students from Database......");
		for(Student student:studentList){
			System.out.println(student);
		}
	}

	private static void createStudent(StudentDao studentDao){
		//Create the Student Object.
		System.out.println("Creating new Student Object.....");
		Student student1=new Student("Suvendu Hatua","suvenduhatua@gmail.com");
		Student student2=new Student("Sonali Samanta","sonali2001@gmail.com");
		Student student3 =new Student("Abhijit  Kudche","abhijit300@gmail.com");

		//Saving the Student Object.
		studentDao.save(student3);
		studentDao.save(student2);
		studentDao.save(student1);
		System.out.println("Student object is saved successfully.");

		//Display the Id of the saved student.
		System.out.println("Generated Student_ID: "+ student3.getStudentID());
	}


}
