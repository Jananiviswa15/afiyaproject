package com.example.sampleProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.sampleProject.EmployeeService.EmpServ;
import com.example.sampleProject.model.Employee;

@Controller
public class EmpCOntroller {


	//autowire ll done automatiocally 
	EmpServ empservice;

	public EmpCOntroller(EmpServ empservice) {
		this.empservice = empservice;
	}

	@GetMapping("/viewAllEmp")
	public String viewAllEmployees(Model model) {
		//name of the attr / obj, value
		//num = 5
		//all the values from dbll b taken through jpa method and stored in empList
		model.addAttribute("empList", empservice.getAllEmployees());
		return "employees"; //name of the html pg (thymeleaf)
	}

	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		//emp.attr --> null;
		//emp.fname = get it fe
		Employee emp = new Employee(); //to store the values enteed by the user
		model.addAttribute("employeeDetails", emp);
		return "createEmp";	
	}

	@PostMapping("/insertToTheDb")
	public String insertAndSave(@ModelAttribute("employeeDetails") Employee empFrmuserEnter) { 
		empservice.insertEmp(empFrmuserEnter);	
		return "redirect:/viewAllEmp";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmp(@PathVariable int id, Model model) {
		model.addAttribute("empFrmDb",empservice.getEmplById(id) );
		return "viewOneEmp";
	}
	
	@PostMapping("/update/{id}")
	public String updateEmp(@PathVariable int id,@ModelAttribute("empFrmDb") Employee fromFrontEnd
			,Model model) {
	Employee existingObject = empservice.getEmplById(id);
	existingObject.setId(id);
	existingObject.setEmail(fromFrontEnd.getEmail());
	existingObject.setFirstName(fromFrontEnd.getFirstName());
	existingObject.setLastName(fromFrontEnd.getLastName()); //updateorsave
	empservice.updateEmpDetails(existingObject);
	
	return "redirect:/viewAllEmp";
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmp(@PathVariable int id) {
		empservice.deleteEmp(id);
		return "redirect:/viewAllEmp";
	}
	
	
	@GetMapping("/logout")
	public String logoutfromApp() {
		return "logout";
	}
	
	//@get mapping(login)
	
}
