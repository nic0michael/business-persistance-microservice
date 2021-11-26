package za.co.business.logic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.business.dtos.SuppliertOrderRequest;
import za.co.business.model.SupplierOrder;
import za.co.business.repositories.SupplierOrderReporitory;
import za.co.business.utils.RequestResponseUtils;

@Component
public class SupplierOrderLogicProcessor {
	
	@Autowired
	SupplierOrderReporitory reporitory;

	public List<SupplierOrder> findAll() {
		return reporitory.findAll();
	}

	public SupplierOrder findBySupplierOrderId(String id) {
		SupplierOrder supplierOrder=null;
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			Long supplierOrderId=Long.parseLong(id);
			supplierOrder= reporitory.findBySupplierOrderId(supplierOrderId);
		}
		return supplierOrder;
	}

	public void delete(String id) {
		if(StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			Long supplierOrderId=Long.parseLong(id);
			reporitory.deleteById(supplierOrderId);
		}		
	}

	public SupplierOrder create(SuppliertOrderRequest supplierOrderRequest) {
		SupplierOrder supplierOrder=RequestResponseUtils.createSupplierOrder(supplierOrderRequest);
		supplierOrder=reporitory.save(supplierOrder);
		return supplierOrder;
	}

	public SupplierOrder update(SuppliertOrderRequest supplierOrderRequest) {
		SupplierOrder supplierOrder=null;
		if(supplierOrderRequest!=null) {
			Long supplierOrderId=supplierOrderRequest.getSupplierOrderId();
			supplierOrder=reporitory.findBySupplierOrderId(supplierOrderId);
			supplierOrder=RequestResponseUtils.updateSupplierOrder(supplierOrder, supplierOrderRequest);
		}
		return supplierOrder;
	}



}
