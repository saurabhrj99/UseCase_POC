package com.incture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AP.ITEM_INFO")
public class ItemDo {

	@Id
	@Column(name="ITEM_NO")
	private String itemNo;
	
	@Column(name="MATERIAL_NO")
	private String materialNo;
	
	@Column(name="MATERIAL_DESC")
	private String materialDesc;
	
	@Column(name="COST")
	private Integer cost;
	
	@Column(name="UNIT")
	private Integer unit;
	
	@Column(name="TOTAL_COST")
	private Integer totalCost;
	
	@Column(name="REQUEST_ID")
	private String requestId;

	public String getItemNo() {
		return itemNo;
	}
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getMaterialNo() {
		return materialNo;
	}
	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}
	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public Integer getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
}
