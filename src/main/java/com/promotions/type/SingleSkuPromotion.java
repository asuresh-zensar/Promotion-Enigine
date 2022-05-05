package com.promotions.type;

public class SingleSkuPromotion extends PromotionType {
	private String skuId;
	private int quantity;
	

	public SingleSkuPromotion(double fixedPrice, String skuId, int quantity) {
		super(fixedPrice);
		this.skuId = skuId;
		this.quantity = quantity;
	}


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

}
