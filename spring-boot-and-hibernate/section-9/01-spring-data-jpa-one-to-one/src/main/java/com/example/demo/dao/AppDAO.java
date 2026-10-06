package com.example.demo.dao;

import com.example.demo.model.entity.Instructor;

public interface AppDAO {

  void save(Instructor instructor);

  Instructor findInstructorById(Integer id);

  void deleteInstructorById(Integer id);

}
