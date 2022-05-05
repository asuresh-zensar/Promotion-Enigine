package com.promotions.model;

import java.util.List;

import com.promotions.type.PromotionType;

public class Cart {

	private List<Item> items;
	private List<PromotionType> activePromotions;
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<PromotionType> getActivePromotions() {
		return activePromotions;
	}
	public void setActivePromotions(List<PromotionType> activePromotions) {
		this.activePromotions = activePromotions;
	}
	public Cart(List<Item> items, List<PromotionType> activePromotions) {
		super();
		this.items = items;
		this.activePromotions = activePromotions;
	}
	public Cart() {
	}
	
}
