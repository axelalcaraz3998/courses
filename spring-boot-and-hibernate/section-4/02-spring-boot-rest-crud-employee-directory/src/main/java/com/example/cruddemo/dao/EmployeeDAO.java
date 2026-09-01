package com.example.cruddemo.dao;

import com.example.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();

  Employee findById(int employeeId);

  Employee save(Employee employee);

  void deleteById(int employeeId);

}
