package com.example.sampleProject.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.sampleProject.EmployeeService.EmpServ;
import com.example.sampleProject.model.Employee;
import com.example.sampleProject.repository.EmployeeRepository;


//service layer
@Service
public class EmpImpl implements EmpServ{
	
	//autowired automatically
	private EmployeeRepository empRepos;
	//u ll able to to access the hibernate JPA methods

	public EmpImpl(EmployeeRepository empRepos) {

		this.empRepos = empRepos;
	}

	public List<Employee> getAllEmployees(){
		return empRepos.findAll(); 
	}
	
	public	Employee insertEmp(Employee obj) {
		return empRepos.save(obj);  
	}

	public Employee getEmplById(int id) {
		return empRepos.findById(id).get();
	}

	public Employee updateEmpDetails(Employee newVal) {
		return empRepos.save(newVal);
		}
	
public void deleteEmp(int id) {
			empRepos.deleteById(id);
	}
}