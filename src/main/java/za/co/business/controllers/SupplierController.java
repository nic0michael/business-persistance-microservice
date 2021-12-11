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

import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SupplierRequest;
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Supplier;

@RestController
@RequestMapping("/business-persistance/v1/supplier")
public class SupplierController {
	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	BusinessLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Supplier>  getSuppliers(){
		return processor.findAllSuppliersSortedByName();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public Supplier  findBySupplierId(@PathVariable String id){
		Supplier supplier=null;
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierId=Long.parseLong(id);		
			supplier= processor.findSupplierBySupplierId(supplierId);
		}
		return supplier;
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierId=Long.parseLong(id);
			processor.deleteSupplier(supplierId);
		}
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Supplier create(@RequestBody SupplierRequest request) {
		return processor.saveSupplier(request);
	}
	
	@PostMapping(value = "/update/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Supplier update(@RequestBody SupplierRequest request,@RequestParam String id){
		Supplier supplier=null;
	
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long supplierId=Long.parseLong(id);
			supplier=processor.findSupplierBySupplierId(supplierId);
			supplier=processor.updateSupplier(supplier, request);
		}
		 
		 return supplier;
	}


}
