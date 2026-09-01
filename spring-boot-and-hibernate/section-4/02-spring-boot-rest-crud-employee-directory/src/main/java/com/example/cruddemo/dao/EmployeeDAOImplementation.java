package com.example.cruddemo.dao;

import com.example.cruddemo.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOImplementation(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

    return query.getResultList();
  }

  @Override
  public Employee findById(int employeeId) {
    return entityManager.find(Employee.class, employeeId);
  }

  @Override
  public Employee save(Employee employee) {
    return entityManager.merge(employee);
  }

  @Override
  public void deleteById(int employeeId) {
    Employee employee = findById(employeeId);

    entityManager.remove(employee);
  }

}
