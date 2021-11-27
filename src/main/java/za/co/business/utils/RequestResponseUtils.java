package za.co.business.utils;


import java.sql.Timestamp;
import java.util.Date;

import za.co.business.dtos.CustomerOrderRequest;
import za.co.business.dtos.CustomerRequest;
import za.co.business.dtos.ProductRequest;
import za.co.business.dtos.SuppliertOrderRequest;
import za.co.business.dtos.SuppliertRequest;
import za.co.business.model.Customer;
import za.co.business.model.CustomerOrder;
import za.co.business.model.Product;
import za.co.business.model.Supplier;
import za.co.business.model.SupplierOrder;

public class RequestResponseUtils {

	public static Customer makeCustomer(CustomerRequest customerDto) {
		Customer customer=new Customer();		
		Timestamp dateCreated=new Timestamp(new Date().getTime());
		customer.setDateCreated(dateCreated);		
		return updateCustomer(customer, customerDto);
	}

	public static Customer updateCustomer(Customer customer, CustomerRequest customerDto) {
		
		customer.setName(customerDto.getName());
		customer.setDeliveryAddress(customerDto.getDeliveryAddress());
		customer.setInvoiceAddress(customerDto.getInvoiceAddress());
		customer.setEmailAddress(customerDto.getEmailAddress());
		customer.setCellPhone(customerDto.getCellPhone());		
		customer.setCredits(null);

		return customer;
	}

	public static CustomerOrder makeCustomerOrder(CustomerOrderRequest customerDto) {
		CustomerOrder customerOrder=new CustomerOrder();
		Timestamp dateCreated=new Timestamp(new Date().getTime());	
		customerOrder.setDateCreated(dateCreated);	
		return updateCustomerOrder(customerOrder, customerDto);
	}

	public static CustomerOrder updateCustomerOrder(CustomerOrder customerOrder, CustomerOrderRequest customerDto) {
		customerOrder.setCustomerId(customerDto.getCustomerId());
		customerOrder.setCustomerRequirements(customerDto.getCustomerRequirements());
		customerOrder.setName(customerDto.getName());
		customerOrder.setProductId(customerDto.getProductId());
		customerOrder.setQuantity(customerDto.getQuantity());
		customerOrder.setSellingPrice(customerDto.getSellingPrice());
		return null;
	}
	


	public static Product createProduct(ProductRequest productDto) {
		Product product=new Product();
		Timestamp dateCreated=new Timestamp(new Date().getTime());	
		product.setDateCreated(dateCreated);
		return updateProduct(product, productDto);
	}

	public static Product updateProduct(Product product, ProductRequest productDto) {
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setCostPrice(productDto.getCostPrice());
		product.setEconomicOrderQuantity(productDto.getEconomicOrderQuantity());
		product.setFileImageId(productDto.getFileImageId());
		product.setReorderLevel(productDto.getReorderLevel());
		product.setSellingPrice(productDto.getSellingPrice());
		product.setStockQuantity(productDto.getStockQuantity());
		product.setSupplierId(productDto.getSupplierId());
		
		return product;
	}
	
	


	public static Supplier createSupplier(SuppliertRequest suppliertRequest) {
		Supplier supplier=new Supplier();
		Timestamp dateCreated=new Timestamp(new Date().getTime());
		supplier.setDateCreated(dateCreated);
		return updateSupplier(supplier,suppliertRequest);
	}


	public static Supplier updateSupplier(Supplier supplier, SuppliertRequest suppliertRequest) {
		supplier.setCellPhone(suppliertRequest.getCellPhone());
		supplier.setContactName(suppliertRequest.getContactName());
		supplier.setEmailAddress(suppliertRequest.getEmailAddress());
		supplier.setName(suppliertRequest.getName());
		supplier.setPhone(suppliertRequest.getPhone());
		supplier.setPhysicalAddress(suppliertRequest.getPhysicalAddress());
		supplier.setPostalAddress(suppliertRequest.getPostalAddress());
		
		return supplier;
	}


	public static SupplierOrder createSupplierOrder(SuppliertOrderRequest supplierOrderRequest) {
		SupplierOrder supplierOrder=new SupplierOrder(); 
		Timestamp dateCreated=new Timestamp(new Date().getTime());
		supplierOrder.setDateCreated(dateCreated);
		return updateSupplierOrder(supplierOrder, supplierOrderRequest);
	}

	public static SupplierOrder updateSupplierOrder(SupplierOrder supplierOrder, SuppliertOrderRequest supplierOrderRequest) {
		supplierOrder.setCostPrice(supplierOrderRequest.getCostPrice());
		supplierOrder.setName(supplierOrderRequest.getName());
		supplierOrder.setProductId(supplierOrderRequest.getProductId());
		supplierOrder.setQuantity(supplierOrderRequest.getQuantity());
		supplierOrder.setSupplierId(supplierOrderRequest.getSupplierId());
		
		return supplierOrder;
	}
	



}
