package com.example.sampleProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.sampleProject.model.Employee;
import com.example.sampleProject.repository.EmployeeRepository;


@SpringBootApplication
public class SampleProjectApplication {
//	@Autowired //on the attr no need of setter methods
	//private EmployeeRepository empRepos;

	public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
		System.out.println("hi");
	}

	
	//varargs//
	/*public void run(String... args)throws Exception{
	Employee emp1 = new Employee("janani", "viswa", "janani@gmail.com");
	Employee emp2 = new Employee("ujjwal", "singh", "ujjwal@gmail.com");
	Employee emp3 = new Employee("diksha", "deshmuk", "deshmuk@gmail.com");
	empRepos.save(emp1);
	empRepos.save(emp2);
	empRepos.save(emp3);
}*/
}
