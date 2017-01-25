package com.incture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AP.HEADER_INFO")
public class HeaderDo {

	@Id
	@GeneratedValue(generator = "REQ_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "REQ_ID_SEQ", sequenceName = "AP.REQ_ID_SEQ", allocationSize=1)
	@Column(name="REQUEST_ID")
	private String requestId;
	
	@Column(name="VENDOR_ID")
	private String vendorId;
	
	@Column(name="PURCHASE_ORGANIZATION")
	private String purchaseOrganization;
	
	@Column(name="PLANT")
	private String plant;
	
	@Column(name="AVAILABLE_BUDGET")
	private Integer availableBudget;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="CREATED_ON")
	private java.util.Date createdOn;
	
	@Column(name="PURCHASE_ORDER_NO")
	private Integer purchaseOrderNo;

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
	
	
}
