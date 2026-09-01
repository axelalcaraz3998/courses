package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override
  public Employee findById(int employeeId) {
    return employeeDAO.findById(employeeId);
  }

  @Override
  @Transactional
  public Employee save(Employee employee) {
    return employeeDAO.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int employeeId) {
    employeeDAO.deleteById(employeeId);
  }

}
