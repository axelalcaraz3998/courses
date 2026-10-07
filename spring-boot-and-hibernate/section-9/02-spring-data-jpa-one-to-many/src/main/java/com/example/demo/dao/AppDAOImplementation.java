package com.example.demo.dao;

import com.example.demo.model.entity.Instructor;
import com.example.demo.model.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImplementation implements AppDAO {

  private EntityManager entityManager;

  @Autowired
  public AppDAOImplementation(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Instructor instructor) {
    entityManager.persist(instructor);
  }

  @Override
  public Instructor findInstructorById(Integer id) {
    return entityManager.find(Instructor.class, id);
  }

  @Override
  @Transactional
  public void deleteInstructorById(Integer id) {
    Instructor instructor = findInstructorById(id);

    // Skip if instructor is not found
    if (instructor == null) {
      return;
    }

    entityManager.remove(instructor);
  }

  @Override
  public InstructorDetail findInstructorDetailById(Integer id) {
    return entityManager.find(InstructorDetail.class, id);
  }

}
