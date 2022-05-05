package com.promotions.model;

public class Item {

	private String skuId;
	private int quantity;
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(String skuId, int quantity) {
		super();
		this.skuId = skuId;
		this.quantity = quantity;
	}
	public Item() {
	}
	
}
