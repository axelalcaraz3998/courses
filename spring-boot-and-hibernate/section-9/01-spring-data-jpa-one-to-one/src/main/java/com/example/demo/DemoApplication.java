package com.example.demo;

import com.example.demo.dao.AppDAO;
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
			createInstructor(appDAO);
			findInstructorById(appDAO, 3);
			deleteInstructorById(appDAO, 3);
		};
	}

	private void createInstructor(AppDAO appDAO) {
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/", "Programmer");
//
//		Instructor instructor = new Instructor("Chad", "Darby", "chad.darby@email.com");
//		instructor.setInstructorDetail(instructorDetail);

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

}
