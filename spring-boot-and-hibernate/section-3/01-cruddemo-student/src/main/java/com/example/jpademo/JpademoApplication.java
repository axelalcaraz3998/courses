package com.example.jpademo;

import com.example.jpademo.dao.StudentDAO;
import com.example.jpademo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (runner) -> {
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// readAllStudents(studentDAO);
			// readStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student newStudent = new Student("Laura", "Murphy", "laura.murphy@example.com");

		System.out.println("Saving student to database...");
		studentDAO.save(newStudent);

		System.out.println("Saved student to database. Generated id: " + newStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Integer id = 1;

		System.out.println("Retrieving student with id: " + id);
		Student student = studentDAO.findById(id);

		System.out.println("Found student: " + student.toString());
	}

	private void readAllStudents(StudentDAO studentDAO) {
		System.out.println("Retrieving all students...");
		List<Student> students = studentDAO.findAll();

		System.out.println("Found " + students.size() + " students:");
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}


	private void readStudentsByLastName(StudentDAO studentDAO) {
		String lastName = "Doe";

		System.out.println("Retrieving all students with last name " + lastName + "...");
		List<Student> students = studentDAO.findByLastName(lastName);

		System.out.println("Found " + students.size() + " students with last name " + lastName + ":");
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		Integer id = 4;

		System.out.println("Retrieving student with id: " + id);
		Student student = studentDAO.findById(id);

		System.out.println("Updating student...");
		student.setFirstName("Mary");
		student.setEmail("mary.murphy@example.com");
		studentDAO.update(student);

		System.out.println("Updated student: " + student.toString());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Integer id = 4;

		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(4);
		System.out.println("Deleted student with id: " + id);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowDeleted);
	}

}
