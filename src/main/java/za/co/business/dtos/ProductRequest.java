package za.co.business.dtos;

import java.sql.Timestamp;

public class ProductRequest {

	private Long productId;
	private Timestamp dateCreated;
	private String name;
	private String description;
	private Long supplierId;
	private Long FileImageId;
	private Long stockQuantity;
	private Long reorderLevel;
	private Long economicOrderQuantity;	
	private Double costPrice;
	private Double sellingPrice;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public Long getFileImageId() {
		return FileImageId;
	}
	public void setFileImageId(Long fileImageId) {
		FileImageId = fileImageId;
	}
	public Long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Long getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public Long getEconomicOrderQuantity() {
		return economicOrderQuantity;
	}
	public void setEconomicOrderQuantity(Long economicOrderQuantity) {
		this.economicOrderQuantity = economicOrderQuantity;
	}
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		return "ProductRequest [productId=" + productId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", description=" + description + ", supplierId=" + supplierId + ", FileImageId=" + FileImageId
				+ ", stockQuantity=" + stockQuantity + ", reorderLevel=" + reorderLevel + ", economicOrderQuantity="
				+ economicOrderQuantity + ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + "]";
	}

	

}
