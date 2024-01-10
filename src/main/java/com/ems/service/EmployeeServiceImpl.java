package com.ems.service;

// EmployeeServiceImpl.java

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);


    }

    @Override
    public Optional<Employee> searchEmployee(long id) {
        // TODO Auto-generated method stub

        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        employeeRepository.save(employee);
    }



}

