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
import za.co.business.logic.BusinessLogicProcessor;
import za.co.business.model.Product;

@RestController
@RequestMapping("/business-persistance/v1/product")
public class ProductController {
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	BusinessLogicProcessor processor;
	
	@PostMapping(value = "/list", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Product>  getCustomers(){
		return processor.findAllProductsSortedByName();
	}
	
	@PostMapping(value = "/list/{id}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product  findByProductId(@PathVariable String id){
		Product product=null;
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long productId=Long.parseLong(id);
			product=processor.findProductByProductId(productId);
		}
		return product;
	}

	@PostMapping(value = "/delete/{id}")
	public void delete(@RequestParam String id){
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long productId=Long.parseLong(id);
			processor.deleteProduct(productId);
		}
	}
	
	@PostMapping(value = "/create", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product create(@RequestBody ProductRequest request) {
		Product product=null;
		product=processor.saveProduct(request);
		return product;
	}
	
	@PostMapping(value = "/update/{id}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Product update(@RequestBody ProductRequest request,@RequestParam String id) {
		Product product=null;
		if(StringUtils.isNoneEmpty(id)&& StringUtils.isNumeric(id)) {
			Long productId=Long.parseLong(id);
			product=processor.findProductByProductId(productId);
			product=processor.updateProduct(product, request);
		}
		return product;
	}


}
