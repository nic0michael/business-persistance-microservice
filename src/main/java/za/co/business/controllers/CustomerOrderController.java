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

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;

@RestController
@RequestMapping("/business-persistance/v1/customer-order")
public class CustomerOrderController {
	private static final Logger log = LoggerFactory.getLogger(CustomerOrderController.class);
	
	@Autowired
	BusinessLogicProcessor  processor;
	

	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerOrder>  getCustomerOrders(){
		return processor.findAllCustomerOrdersSortedByDate();
	}
	
	@PostMapping(value = "/listnotpaid/{customerid}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerOrder>  getCustomerOrdersNotPaid(@PathVariable String customerid){	
		Customer customer=null;
		if(StringUtils.isNotEmpty(customerid)&& StringUtils.isNumeric(customerid)) {
			Long customerId=Long.parseLong(customerid);
			customer=processor.findCustomerByCustomerId(customerId);
		}
		return processor.findAllCustomerOrdersByCustomerNotPaid(customer);
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder  findByCustomerId(@PathVariable String id){
		CustomerOrder customerOrder=null;	
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerOrderId=Long.parseLong(id);
			customerOrder=processor.findCustomerOrderByCustomerOrderId(customerOrderId);
		}
		return customerOrder;
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerOrderId=Long.parseLong(id);
			processor.deleteCustomerOrder(customerOrderId);
		}
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder create(@RequestBody CustomerOrderRequest request) {
		return processor.saveCustomerOrder(request);
	}
	
	@PostMapping(value = "/update/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder update(@RequestBody CustomerOrderRequest request,@RequestParam String id){
		CustomerOrder customerOrder=null;	
		if(StringUtils.isNotEmpty(id)&& StringUtils.isNumeric(id)) {
			Long customerOrderId=Long.parseLong(id);
			customerOrder=processor.findCustomerOrderByCustomerOrderId(customerOrderId);
		}
		return processor.updateCustomerOrder(customerOrder, request);
	}

}
