package com.ems.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


//	List<Employee> findByfirst_name(String first_name);

}