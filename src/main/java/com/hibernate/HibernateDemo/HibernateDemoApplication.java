package com.hibernate.HibernateDemo;

import com.hibernate.HibernateDemo.dao.*;
import com.hibernate.HibernateDemo.pojos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.hibernate.HibernateDemo.*"})
public class HibernateDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			StudentDao studentDao, PersonDao personDao, EmployeeDao employeeDao, EmpInheritanceDao empInheritanceDao, EmployeeJOINDao employeeJOINDao,OneToManyDao oneToManyDao){
		return runner->{
			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Methods for StudentDao<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//			createStudent(studentDao);
//			readStudentById(studentDao);
//			displayStudentsByName(studentDao);
//			searchByEmail(studentDao);
//			updateStudent(studentDao);
//			updateWholeTable(studentDao);
//			deleteStudent(studentDao);
//			deleteAllStudents(studentDao);

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Methods for PersonDao<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//			addPerson(personDao);

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Methods of EmployeeDao<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,
//			addEmployee(employeeDao);

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Methods of EmpInheritanceDao <<<<<<<<<<<<<<<<<<<<<<
//			addEmployeeInheritance(empInheritanceDao);

			//***************************************** Join Table strategy ************************************
//			addEmployee_Join(employeeJOINDao);

			//***************************************** OneToMany RelationShip ************************************
			saveOneToMany(oneToManyDao);
		};
	}
	//***************************************** OneToMany RelationShip ************************************
	private void saveOneToMany(OneToManyDao oneToManyDao){
		//creating Vendor instance
		Vendor_Pojo vendorPojo=new Vendor_Pojo();
		vendorPojo.setVendorName("IBM");
		//Creating multiple Customer instance
		Customer_Pojo customerPojo1=new Customer_Pojo();
		customerPojo1.setCustomerName("TCS");
		customerPojo1.setCustomerEmail("tcsindia@de.in");
		customerPojo1.setCustomerID(2020);

		Customer_Pojo customerPojo2=new Customer_Pojo();
		customerPojo2.setCustomerID(2045); customerPojo2.setCustomerName("ZOHO Corporation");customerPojo2.setCustomerEmail("zohosupport@com.in");

		//Adding customers to Vendor_Pojo
		Set<Customer_Pojo> customers=new HashSet<>();
		customers.add(customerPojo1); customers.add(customerPojo2);
		vendorPojo.setCustomers(customers);


		//Calling the saving method
		oneToManyDao.save(vendorPojo);

		System.out.println("OneToMany Relationship has been established successfully....");
	}

	private void addEmployee_Join(EmployeeJOINDao employeeJOINDao){
		//Creating permanent Employee
		PermanentEmp_JOIN emp1=new PermanentEmp_JOIN();
		emp1.setEmpName("Suvendu Hatua");emp1.setEmpAge(24); emp1.setSalary(39000);emp1.setIncentive(11);

		//Creating Contract Employee
		ContractEmp_JOIN emp2=new ContractEmp_JOIN();
		emp2.setEmpName("Sonali Samanta"); emp2.setEmpAge(22); emp2.setPerDaySalary(1200); emp2.setDuration(10);

		//Saving both the permanent and Contractual Employees
		employeeJOINDao.savePermanentEmp(emp1);
		employeeJOINDao.saveContractEmp(emp2);
		System.out.println("Both the employees has been added successfully...");
	}

	private  void addEmployeeInheritance(EmpInheritanceDao empInheritanceDao){
		//Saving permanent Employee
		PermanentEmployee permanentEmployee=new PermanentEmployee();
		permanentEmployee.setEmpName("Akash Maity"); permanentEmployee.setSalary(37000.23f);
		permanentEmployee.setIncentive(9000.76f);
		empInheritanceDao.savePermanentEmployee(permanentEmployee);

		//Saving permanent Employee
		ContractEmployee contractEmployee=new ContractEmployee();
		contractEmployee.setEmpName("Sonali Samanta"); contractEmployee.setPerDaySalary(1200.56f);
		contractEmployee.setDurationDay(10);
		empInheritanceDao.saveContractEmployee(contractEmployee);
	}

	private void addEmployee(EmployeeDao employeeDao){
		//creating Employee Instance.
		Employee_Pojo employeePojo=new Employee_Pojo();
		employeePojo.setEmpEmail("Suvendu@gmail.com");
		employeePojo.setFirstName("Nirmal"); employeePojo.setLastName("Samanta");
		//Creating Address instance
		Address a1=new Address();
		a1.setCityName("Medinipur"); a1.setState("West Bengal"); a1.setPinNumber(721152);
		Address a2=new Address();
		a2.setCityName("Gobardhanpur"); a2.setState("Bihar"); a2.setPinNumber(721140);
		employeePojo.getAddresses().add(a1);
		employeePojo.getAddresses().add(a2);

		System.out.println("*********************** Creation of Employee ******************");
		employeeDao.addEmployee(employeePojo);
		System.out.println("Employee has been added successfully...");
		System.out.println("Employee ID:"+employeePojo.getEmpId());

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
