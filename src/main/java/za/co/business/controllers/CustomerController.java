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

import za.co.business.dtos.CustomerRequest;
import za.co.business.logic.CustomerLogicProcessor;
import za.co.business.model.Customer;

@RestController
@RequestMapping("/business-persistance/v1/customer")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Customer>  getCustomers(){
		List<Customer> customers= processor.getCustomers();
		log.info("CustomerController | findByCustomerId | customers : "+customers);
		return customers;
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer  findByCustomerId(@PathVariable String id){		
		Customer customer= processor.findByCustomerId(id);
		log.info("CustomerController | findByCustomerId | id : "+id+" customer : "+customer);
		return customer;
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
