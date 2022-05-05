package com.promotions;

import java.util.List;
import java.util.Set;

import com.promotions.model.Cart;
import com.promotions.model.Item;
import com.promotions.pricelist.PriceList;
import com.promotions.type.PromotionType;

public class PromotionService {
	
	private PriceList priceList;
	public double findOrderTotal(Cart cart) {
		if(cart !=null) {
			List<Item> items=cart.getItems();
			if(items!=null&&!items.isEmpty()) {
				List<PromotionType> activePromotions=cart.getActivePromotions();
			}
			
			return orderTotal(items);
			
		}
		
		return 0;
	}
	
	private double orderTotal(List<Item> items) {
		double total=0.0;
		for(Item item:items) {
			total+=item.getQuantity()*PriceList.getPrice(item.getSkuId());
		}
		return total;
		
	}
}
