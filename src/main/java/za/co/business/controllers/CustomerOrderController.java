package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.logic.CustomerOrderLogicProcessor;
import za.co.business.model.CustomerOrder;

@RestController
@RequestMapping("/business-persistance/customer-order")
public class CustomerOrderController {
	
	@Autowired
	CustomerOrderLogicProcessor  processor;
	

	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<CustomerOrder>  getCustomers(){
		return processor.getCustomerOrders();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder  findByCustomerId(@RequestParam String id){		
		return processor.findByCustomerOrderId(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		processor.delete(id);
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder create(@RequestBody CustomerOrderRequest customerOrderRequest) {
		return processor.create(customerOrderRequest);
	}
	
	@PostMapping(value = "/update", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CustomerOrder update(@RequestBody CustomerOrderRequest customerOrderRequest) {
		return processor.update(customerOrderRequest);
	}

}
