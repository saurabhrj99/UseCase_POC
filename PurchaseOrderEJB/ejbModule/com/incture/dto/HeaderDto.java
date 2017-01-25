package com.incture.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HeaderDto implements Serializable {

	private static final long serialVersionUID = 6590307162905722453L;
	
	private String requestId;
	private String vendorId;
	private String purchaseOrganization;
	private String plant;
	private Integer availableBudget;
	private String createdBy;
	private java.util.Date createdOn;
	private Integer purchaseOrderNo;
	private List<ItemDto> itemDtos;
	
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getPurchaseOrganization() {
		return purchaseOrganization;
	}
	public void setPurchaseOrganization(String purchaseOrganization) {
		this.purchaseOrganization = purchaseOrganization;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public Integer getAvailableBudget() {
		return availableBudget;
	}
	public void setAvailableBudget(Integer availableBudget) {
		this.availableBudget = availableBudget;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public java.util.Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(java.util.Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getPurchaseOrderNo() {
		return purchaseOrderNo;
	}
	public void setPurchaseOrderNo(Integer purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}
	public List<ItemDto> getItemDtos() {
		return itemDtos;
	}
	public void setItemDtos(List<ItemDto> itemDtos) {
		this.itemDtos = itemDtos;
	}
	

}
