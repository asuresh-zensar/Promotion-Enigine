package com.promotions.type;


public abstract class PromotionType {

	public int priority;
	public double fixedPrice;
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public PromotionType(int priority, double fixedPrice) {
		super();
		this.priority = priority;
		this.fixedPrice = fixedPrice;
	}
	
}
