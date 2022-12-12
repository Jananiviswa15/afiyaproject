package com.example.sampleProject.EmployeeService;

import java.util.List;

import com.example.sampleProject.model.Employee;

public interface EmpServ {
	//provide method dec for my crud methods
Employee insertEmp(Employee obj);
List<Employee>	getAllEmployees();  //select * from t1 --> all recrd --> employee obj
Employee getEmplById(int id); //select * from t1 where id = 3
Employee updateEmpDetails(Employee newVal); //update t1 set col = "newVal"
void deleteEmp(int id);
}
