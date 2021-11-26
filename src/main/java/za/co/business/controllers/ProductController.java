package za.co.business.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import za.co.business.dtos.ProductRequest;
import za.co.business.logic.ProductLogicProcessor;
import za.co.business.model.Product;

@RestController
@RequestMapping("/business-persistance/product")
public class ProductController {

	@Autowired
	ProductLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Product>  getCustomers(){
		return processor.getProducts();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product  findByProductId(@RequestParam String id){		
		return processor.findByProductId(id);
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){	
		processor.delete(id);
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product create(@RequestBody ProductRequest productDto) {
		return processor.create(productDto);
	}
	
	@PostMapping(value = "/update", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product update(@RequestBody ProductRequest productDto) {
		return processor.update(productDto);
	}


}
