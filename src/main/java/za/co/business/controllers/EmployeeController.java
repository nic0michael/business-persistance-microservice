package za.co.business.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.AuthenticationRequest;
import za.co.business.dtos.AuthenticationResponse;
import za.co.business.dtos.CustomerRequest;
import za.co.business.logic.EmployeeLogicProcessor;
import za.co.business.model.Customer;
import za.co.business.model.Employee;

@RestController
@RequestMapping("/business-persistance/v1/employee")
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Employee>  getEmployees(){
		return processor.findAll();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Employee  findByCustomerId(@PathVariable String id){		
		return processor.findByEmployeeId(id);
	}
	
	@PostMapping(value = "/auth", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		return processor.authenticate(authenticationRequest);
	}
	

}
