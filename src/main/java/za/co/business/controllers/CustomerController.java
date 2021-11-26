package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.CustomerRequest;
import za.co.business.logic.CustomerLogicProcessor;
import za.co.business.model.Customer;

@RestController
@RequestMapping("/business-persistance/customer")
public class CustomerController {
	
	@Autowired
	CustomerLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Customer>  getCustomers(){
		return processor.getCustomers();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer  findByCustomerId(@RequestParam String id){		
		return processor.findByCustomerId(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		processor.delete(id);
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer create(@RequestBody CustomerRequest customerDto) {
		return processor.create(customerDto);
	}
	
	@PostMapping(value = "/update", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer update(@RequestBody CustomerRequest customerDto) {
		return processor.update(customerDto);
	}

}
