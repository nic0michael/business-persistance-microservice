package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.CustomerRequest;
import za.co.business.model.Customer;
import za.co.business.repositories.CustomerRepository;
import za.co.business.utils.RequestResponseUtils;

@Component
public class CustomerLogicProcessor {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer findByCustomerId(String id) {
		Customer customer=null;
		Long customerId; 
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			customerId=Long.parseLong(id);
			customer=customerRepository.findByCustomerId(customerId);
		}
		return customer;
	}

	public void delete(String id) {
		Long customerId; 
		if(StringUtils.isNotEmpty(id)) {
			customerId=Long.parseLong(id);
			customerRepository.deleteById(customerId);
		}
	}

	public Customer create(CustomerRequest customerDto) {
		Customer customer=RequestResponseUtils.makeCustomer(customerDto);
		Customer customerSaved = customerRepository.save(customer);
		return customerSaved;
	}

	public Customer update(CustomerRequest customerDto) {
		Customer customer=null;
		
		if(customerDto!= null ) {
			customer=customerRepository.findByCustomerId(customerDto.getCustomerId());
			customer=RequestResponseUtils.updateCustomer(customer,customerDto);
		}
			
			return customer;
	}
}
