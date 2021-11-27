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

import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SuppliertRequest;
import za.co.business.logic.ProductLogicProcessor;
import za.co.business.logic.SupplierLogicProcessor;
import za.co.business.model.Supplier;

@RestController
@RequestMapping("/business-persistance/v1/supplier")
public class SupplierController {
	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	SupplierLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Supplier>  getSuppliers(){
		return processor.getSuppliers();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) 
	public Supplier  findBySupplierId(@PathVariable String id){		
		return processor.findBySupplierId(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		processor.delete(id);
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Supplier create(@RequestBody SuppliertRequest suppliertRequest) {
		return processor.create(suppliertRequest);
	}
	
	@PostMapping(value = "/update", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Supplier update(@RequestBody SuppliertRequest suppliertRequest) {
		return processor.update(suppliertRequest);
	}


}
