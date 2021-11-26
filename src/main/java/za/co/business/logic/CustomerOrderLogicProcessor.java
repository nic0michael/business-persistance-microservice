package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.repositories.CustomerOrderRepository;
import za.co.business.utils.RequestResponseUtils;

@Component
public class CustomerOrderLogicProcessor {
	
	@Autowired
	CustomerOrderRepository customerOrderRepository;


	public List<CustomerOrder> getCustomerOrders() {
		return customerOrderRepository.findAll();
	}
	
	public CustomerOrder findByCustomerOrderId(String id) {
		CustomerOrder customerOrder=null;
		Long customerId; 
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			customerId=Long.parseLong(id);
			customerOrder=customerOrderRepository.findByCustomerOrderId(customerId);
		}
		return customerOrder;
	}

	public void delete(String id) {
		Long customerOrderId; 
		if(StringUtils.isNotEmpty(id)) {
			customerOrderId=Long.parseLong(id);
			customerOrderRepository.deleteById(customerOrderId);
		}
	}

	public CustomerOrder create(CustomerOrderRequest customerDto) {
		CustomerOrder customer=RequestResponseUtils.makeCustomerOrder(customerDto);
		CustomerOrder customerSaved = customerOrderRepository.save(customer);
		return customerSaved;
	}

	public CustomerOrder update(CustomerOrderRequest customerDto) {
		CustomerOrder customerOrder=null;
		
		if(customerDto!=null ) {
			Long customerId=customerDto.getCustomerId();
			customerOrder=customerOrderRepository.findByCustomerOrderId(customerId);
			customerOrder=RequestResponseUtils.updateCustomerOrder(customerOrder,customerDto);
		}
			
			return customerOrder;
	}
}
