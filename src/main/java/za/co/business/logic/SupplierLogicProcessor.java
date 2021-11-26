package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.SuppliertRequest;
import za.co.business.model.Supplier;
import za.co.business.repositories.SupplierRepository;
import za.co.business.utils.RequestResponseUtils;

@Component
public class SupplierLogicProcessor {
	
	@Autowired
	SupplierRepository repository;

	public List<Supplier> getSuppliers() {		
		return repository.findAll();
	}

	public Supplier findBySupplierId(String id) {
		Supplier supplier=null;
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			Long supplierId=Long.parseLong(id);
			supplier=repository.findBySupplierId(supplierId);
		};
		return supplier;
	}

	public void delete(String id) {
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			Long supplierId=Long.parseLong(id);
			repository.deleteById(supplierId);
		}		
	}

	public Supplier create(SuppliertRequest suppliertRequest) {
		Supplier supplier=null;
		supplier=RequestResponseUtils.createSupplier(suppliertRequest);
		supplier=repository.save(supplier);
		return supplier;
	}

	public Supplier update(SuppliertRequest suppliertRequest) {
		Supplier supplier=null;
		if(suppliertRequest !=null) {
			Long supplierId = suppliertRequest.getSupplierId();
			supplier=repository.findBySupplierId(supplierId);
			supplier=RequestResponseUtils.updateSupplier(supplier,suppliertRequest);
			supplier=repository.save(supplier);
		}
		return supplier;
	}
	
	

}
