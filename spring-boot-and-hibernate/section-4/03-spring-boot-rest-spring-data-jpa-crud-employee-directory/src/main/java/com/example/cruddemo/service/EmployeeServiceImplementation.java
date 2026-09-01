package com.example.cruddemo.service;

import com.example.cruddemo.model.Employee;
import com.example.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(int employeeId) {
    Optional<Employee> result = employeeRepository.findById(employeeId);

    Employee employee = null;
    if (result.isPresent()) {
      employee = result.get();
    }

    return employee;
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteById(int employeeId) {
    employeeRepository.deleteById(employeeId);
  }

}
