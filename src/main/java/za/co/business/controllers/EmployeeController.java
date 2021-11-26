package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.logic.EmployeeLogicProcessor;
import za.co.business.model.Employee;

@RestController
@RequestMapping("/business-persistance/employee")
public class EmployeeController {
	@Autowired
	EmployeeLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Employee>  getEmployees(){
		return processor.findAll();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Employee  findByCustomerId(@RequestParam String id){		
		return processor.findByEmployeeId(id);
	}

}
