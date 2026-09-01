package com.example.cruddemo.controller;

import com.example.cruddemo.model.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  private EmployeeService employeeService;
  private JsonMapper jsonMapper;

  @Autowired
  public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
    this.employeeService = employeeService;
    this.jsonMapper = jsonMapper;
  }

  @GetMapping("/employees")
  public List<Employee> getEmployees() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{employeeId}")
  public Employee getEmployeeById(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    return employee;
  }

  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    // Override id in case request body contains one
    employee.setId(null);

    return employeeService.save(employee);
  }

  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @PatchMapping("/employees/{employeeId}")
  public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> payload) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    if (payload.containsKey("id")) {
      throw new RuntimeException("Employee id not allowed in request body - " + employeeId);
    }

    Employee patchedEmployee = jsonMapper.updateValue(employee, payload);

    return employeeService.save(patchedEmployee);
  }

  @DeleteMapping("/employees/{employeeId}")
  public void deleteEmployeeById(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found - " + employeeId);
    }

    employeeService.deleteById(employeeId);
  }

}
