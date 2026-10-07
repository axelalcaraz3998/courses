package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Instructor;
import com.example.demo.model.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return (runner) -> {
//			createInstructor(appDAO);
//			findInstructorById(appDAO, 3);
//			deleteInstructorById(appDAO, 3);
//			findInstructorDetailById(appDAO, 2);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/", "Programmer");
//
//		Instructor instructor = new Instructor("Chad", "Darby", "chad.darby@email.com");
//		instructor.setInstructorDetail(instructorDetail);
//
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/", "Guitarist");
//
//		Instructor instructor = new Instructor("Madhu", "Patel", "chad.darby@email.com");
//		instructor.setInstructorDetail(instructorDetail);

		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/", "Hobby");

		Instructor instructor = new Instructor("Fake", "Name", "fake.name@email.com");
		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
		System.out.println("Saved instructor: " + instructor.toString());
	}

	private void findInstructorById(AppDAO appDAO, Integer id) {
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Found instructor with id - " + id + ": " + instructor.toString());
	}

	private void deleteInstructorById(AppDAO appDAO, Integer id) {
		appDAO.deleteInstructorById(id);
		System.out.println("Deleted instructor with id - " + id);
	}

	private void findInstructorDetailById(AppDAO appDAO, Integer id) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Found instructor detail with id - " + id + ": " + instructorDetail.toString());

		Instructor instructor = instructorDetail.getInstructor();
		System.out.println("Instructor detail has instructor: " + instructor.toString());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		InstructorDetail instructorDetail1 = new InstructorDetail("https://www.youtube.com/", "Programmer");

		Instructor instructor1 = new Instructor("Chad", "Darby", "chad.darby@email.com");
		instructor1.setInstructorDetail(instructorDetail1);

		InstructorDetail instructorDetail2 = new InstructorDetail("https://www.youtube.com/", "Guitarist");

		Instructor instructor2= new Instructor("Madhu", "Patel", "chad.darby@email.com");
		instructor2.setInstructorDetail(instructorDetail2);

		Course course1 = new Course("Spring Boot 4 and Hibernate");
		Course course2 = new Course("Java Masterclass");
		Course course3 = new Course("React and Next.js");
		Course course4 = new Course("Go Programming Language");

		instructor1.add(course1);
		instructor1.add(course2);
		instructor2.add(course3);
		instructor2.add(course4);

		appDAO.save(instructor1);
		System.out.println("Saved instructor: " + instructor1.toString());
		System.out.println("Saved courses for instructor - " + instructor1.getId() + ": " + instructor1.getCourses());

		appDAO.save(instructor2);
		System.out.println("Saved instructor: " + instructor2.toString());
		System.out.println("Saved courses for instructor - " + instructor2.getId() + ": " + instructor2.getCourses());
	}

}
