package com.ems.service;

// EmployeeService.java

import java.util.List;
import java.util.Optional;

import com.ems.model.Employee;


public interface EmployeeService {
    List<Employee> getAllEmployees();


    void addEmployee(Employee employee);

    Optional<Employee> searchEmployee(long id);

    //	void updateEmployee(Employee employee);
    void deleteEmployeeById(long id);


    void updateEmployee(Employee employee);
}

