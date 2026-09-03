package com.example.cruddemo.service;

import com.example.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(int employeeId);

  Employee save(Employee employee);

  void deleteById(int employeeId);

}
