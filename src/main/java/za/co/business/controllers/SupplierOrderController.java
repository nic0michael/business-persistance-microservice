package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.logic.EmployeeLogicProcessor;
import za.co.business.logic.SupplierOrderLogicProcessor;
import za.co.business.model.Employee;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.SupplierOrderReporitory;

@RestController
@RequestMapping("/business-persistance/supplier-order")
public class SupplierOrderController {
	

	@Autowired
	SupplierOrderReporitory repository;
	
	@Autowired
	SupplierOrderLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public List<SupplierOrder> listall(Model model) {
		List<SupplierOrder> supplierOrders = processor.findAllSupplierOrders();
		
		return supplierOrders;
		
	}

}
