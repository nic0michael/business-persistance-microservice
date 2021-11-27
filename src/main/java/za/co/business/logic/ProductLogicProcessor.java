package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.ProductRequest;
import za.co.business.model.Customer;
import za.co.business.model.Product;
import za.co.business.repositories.ProductRepository;
import za.co.business.utils.RequestResponseUtils;

@Component
public class ProductLogicProcessor {
	private static final Logger log = LoggerFactory.getLogger(ProductLogicProcessor.class);
	
	@Autowired
	ProductRepository repository;

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product findByProductId(String id) {
		Product product=null;
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id) ) {
			Long productId=Long.parseLong(id);
			product= repository.findByProductId(productId);
		}
		return product;
	}

	public void delete(String id) {
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id) ) {
			Long productId=Long.parseLong(id);
			repository.deleteById(productId);
		}		
	}

	public Product create(ProductRequest productDto) {
		Product product=RequestResponseUtils.createProduct(productDto);
		Product savedProduct=repository.save(product);
		return savedProduct;
	}

	public Product update(ProductRequest productDto) {
		Product product=null;
		if(productDto!=null ) {
			long productId=productDto.getProductId();
			product=repository.findByProductId(productId);
			RequestResponseUtils.updateProduct(product,productDto);
		}		
				
		return product;
	}



}
