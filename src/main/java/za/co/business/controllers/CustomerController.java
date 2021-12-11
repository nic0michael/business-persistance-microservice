package za.co.business.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Customer;
import za.co.business.utils.RequestResponseUtils;

@RestController
@RequestMapping("/business-persistance/v1/customer")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	BusinessLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Customer>  getCustomers(){
		List<Customer> customers= processor.findAllCustomersSortedByName();
		log.info("CustomerController | findByCustomerId | customers : "+customers);
		return customers;
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer  findByCustomerId(@PathVariable String id){		
		Customer customer=null;
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerId=Long.parseLong(id);
			customer=processor.findCustomerByCustomerId(customerId);
		}
		log.info("CustomerController | findByCustomerId | id : "+id+" customer : "+customer);
		return customer;
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerId=Long.parseLong(id);
			processor.deleteCustomer(customerId);
		}
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer create(@RequestBody CustomerRequest request) {
		return processor.saveCustomer(request);
	}
	
	@PostMapping(value = "/update/{id}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer update(@RequestBody CustomerRequest request,@RequestParam String id){
		Customer customer=null;
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerId=Long.parseLong(id);
			customer=processor.findCustomerByCustomerId(customerId);			
			customer=processor.updateCustomer(customer, request);
		}
		return customer;
	}

}
