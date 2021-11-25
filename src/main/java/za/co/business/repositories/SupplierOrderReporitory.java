package za.co.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.business.model.SupplierOrder;

public interface SupplierOrderReporitory extends JpaRepository<SupplierOrder, Long> {

	public SupplierOrder findBySupplierOrderId(Long supplierOrderId);

}
