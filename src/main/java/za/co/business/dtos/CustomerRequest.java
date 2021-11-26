package za.co.business.dtos;

import java.sql.Timestamp;



public class CustomerRequest {

	private Long customerId;
	private Timestamp dateCreated;
	private String name;
	private Integer tableNr;
	private String carRegristrationNr;
	private String deliveryAddress;
	private String invoiceAddress;
	private String emailAddress;
	private String cellPhone;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTableNr() {
		return tableNr;
	}
	public void setTableNr(Integer tableNr) {
		this.tableNr = tableNr;
	}
	public String getCarRegristrationNr() {
		return carRegristrationNr;
	}
	public void setCarRegristrationNr(String carRegristrationNr) {
		this.carRegristrationNr = carRegristrationNr;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getInvoiceAddress() {
		return invoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	@Override
	public String toString() {
		return "CustomerRequest [customerId=" + customerId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", tableNr=" + tableNr + ", carRegristrationNr=" + carRegristrationNr + ", deliveryAddress="
				+ deliveryAddress + ", invoiceAddress=" + invoiceAddress + ", emailAddress=" + emailAddress
				+ ", cellPhone=" + cellPhone + "]";
	}
	

}
