package com.example.sampleProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sampleProject.model.Employee;

//jpa repository / repository layer / dao layer 

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
