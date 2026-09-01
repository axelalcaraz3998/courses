package com.example.demo.controller;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

  private List<Student> students;

  @PostConstruct
  public void setup() {
    students = new ArrayList<>();
    students.add(new Student("Poornima", "Patel"));
    students.add(new Student("Mario", "Rossi"));
    students.add(new Student("Mary", "Smith"));
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable Integer studentId) {
    if ((studentId >= students.size()) || (studentId < 0)) {
      throw new StudentNotFoundException("Student id not found - " + studentId);
    }

    return students.get(studentId);
  }

}
