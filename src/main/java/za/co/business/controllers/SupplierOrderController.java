package za.co.business.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.SupplierOrderRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.SupplierOrderRepository;

@RestController
@RequestMapping("/business-persistance/v1/supplier-order")
public class SupplierOrderController {
	private static final Logger log = LoggerFactory.getLogger(SupplierOrderController.class);
	
	
	@Autowired
	BusinessLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<SupplierOrder> findAll() {
		return processor.findAllSupplierOrdersSortedByDate();		
	}

	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public SupplierOrder  findBySupplierOrderId(@PathVariable String id){
		SupplierOrder supplierOrder=null;
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierOrderId=Long.parseLong(id);
			supplierOrder=processor.findSupplierOrderBySupplierOrderId(supplierOrderId);
		}
		return supplierOrder;
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){

		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierOrderId=Long.parseLong(id);
			processor.deleteSupplierOrder(supplierOrderId);
		}
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SupplierOrder create(@RequestBody SupplierOrderRequest request) {
		return processor.saveSupplierOrder(request);
	}
	
	@PostMapping(value = "/update/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public SupplierOrder update(@RequestBody SupplierOrderRequest request,@RequestParam String id) {
		SupplierOrder supplierOrder=null;
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierOrderId=Long.parseLong(id);
			supplierOrder=processor.findSupplierOrderBySupplierOrderId(supplierOrderId);
			supplierOrder=processor.updateSupplierOrder(supplierOrder, request);
		}
		return supplierOrder;
	}

}
