package com.example.demo.dao;

import com.example.demo.model.entity.Instructor;
import com.example.demo.model.entity.InstructorDetail;

public interface AppDAO {

  void save(Instructor instructor);

  Instructor findInstructorById(Integer id);

  void deleteInstructorById(Integer id);

  InstructorDetail findInstructorDetailById(Integer id);

}
