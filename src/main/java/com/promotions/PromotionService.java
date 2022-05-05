package com.promotions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.promotions.model.Cart;
import com.promotions.model.Item;
import com.promotions.pricelist.PriceList;
import com.promotions.type.GroupedSkuPromotion;
import com.promotions.type.PromotionType;
import com.promotions.type.SingleSkuPromotion;

@Service
public class PromotionService {
	
	public double findOrderTotal(Cart cart) {
		double total=0.0;
		if(cart !=null) {
			List<Item> items=cart.getItems();
			if(items!=null&&!items.isEmpty()) {
				List<PromotionType> activePromotions=cart.getActivePromotions();
				if(activePromotions!=null&&!activePromotions.isEmpty()) {
					SingleSkuPromotion sPromotion=null;
					Set<String> skus=items.stream().map(item->item.getSkuId()).collect(Collectors.toSet());
					Map<String,Integer> itemQuantityMap= new HashMap<>();
					items.forEach(item->itemQuantityMap.put(item.getSkuId(), item.getQuantity()));
					Map<String,Boolean> appliedMap=new HashMap<String, Boolean>();
					skus.forEach(skuId->appliedMap.put(skuId, false));
					String currentSku=null;
					for(PromotionType promotion:activePromotions) {
						if(promotion instanceof SingleSkuPromotion) {
							sPromotion= (SingleSkuPromotion) promotion;
							currentSku=sPromotion.getSkuId();
							int itemQuantity=itemQuantityMap.get(sPromotion.getSkuId());
							int promotionQuqntity=sPromotion.getQuantity();
							if(!appliedMap.get(currentSku)&&skus.contains(currentSku) &&itemQuantity>=promotionQuqntity) {
								total+=(itemQuantity/promotionQuqntity)*sPromotion.getFixedPrice()+(itemQuantity%promotionQuqntity)*PriceList.getPrice(currentSku);
								appliedMap.put(currentSku,true);
								
							}
						}else if(promotion instanceof GroupedSkuPromotion) {
							GroupedSkuPromotion gPromotion=(GroupedSkuPromotion) promotion;
							Set<String> promotionSkus=new HashSet<String>(gPromotion.getSkus());
							promotionSkus.retainAll(skus);
							if(promotionSkus.size()==gPromotion.getSkus().size()) {
								
								Boolean applied=Boolean.FALSE;
								for(String gsku:promotionSkus) {
									if(appliedMap.get(gsku))
										applied=Boolean.TRUE;
									
								}
								if(!applied) {
									total+=gPromotion.getFixedPrice();
									promotionSkus.forEach(s->appliedMap.put(s, true));
								}
							}
						}
					}
					List<String> remainingSku=appliedMap.entrySet().stream().filter(s->!s.getValue()).map(s->s.getKey()).collect(Collectors.toList());
					if(remainingSku != null &&!remainingSku.isEmpty()) {
						for(String sku:remainingSku) {
							total+=itemQuantityMap.get(sku)*PriceList.getPrice(sku);
						}
					}
					
				}else {
					return orderTotal(items);
				}
			}
		}
		
		return total;
	}
	
	private double orderTotal(List<Item> items) {
		double total=0.0;
		for(Item item:items) {
			total+=item.getQuantity()*PriceList.getPrice(item.getSkuId());
		}
		return total;
		
	}
	
}
