package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.SuppliertOrderRequest;
import za.co.business.logic.SupplierOrderLogicProcessor;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.SupplierOrderReporitory;

@RestController
@RequestMapping("/business-persistance/supplier-order")
public class SupplierOrderController {
	
	
	@Autowired
	SupplierOrderLogicProcessor processor;
	
	@GetMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SupplierOrder> findAll() {
		return processor.findAll();		
	}

	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public SupplierOrder  findBySupplierOrderId(@RequestParam String id){		
		return processor.findBySupplierOrderId(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		processor.delete(id);
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SupplierOrder create(@RequestBody SuppliertOrderRequest supplierOrderRequest) {
		return processor.create(supplierOrderRequest);
	}
	
	@PostMapping(value = "/update", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SupplierOrder update(@RequestBody SuppliertOrderRequest supplierOrderRequest) {
		return processor.update(supplierOrderRequest);
	}

}
