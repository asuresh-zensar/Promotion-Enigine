package com.promotions.type;

import java.util.Set;

public class GroupedSkuPromotion extends PromotionType {

	private Set<String> skus;

	public Set<String> getSkus() {
		return skus;
	}

	public void setSkus(Set<String> skus) {
		this.skus = skus;
	}

	public GroupedSkuPromotion(int priority, double fixedPrice, Set<String> skus) {
		super(priority, fixedPrice);
		this.skus = skus;
	}
	
	
}
