package com.promotions.resource;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promotions.PromotionService;
import com.promotions.model.Cart;
import com.promotions.model.Item;
import com.promotions.type.GroupedSkuPromotion;
import com.promotions.type.SingleSkuPromotion;

@RestController
public class PromotionEngineRestResource {

	private Cart cart=new Cart();
	@Autowired
	private PromotionService service;

	public PromotionEngineRestResource() {
		
		//cart.setItems(Arrays.asList(new Item("A",3),new Item("B",2),new Item("C",3),new Item("D",4)));
		cart.setItems(Arrays.asList(new Item("A",5),new Item("B",5),new Item("C",1)));
		//cart.setItems(Arrays.asList(new Item("A",3),new Item("B",5),new Item("C",1),new Item("D",1)));
		cart.setActivePromotions(Arrays.asList(new SingleSkuPromotion( 130, "A", 3),new SingleSkuPromotion( 45, "B", 2),new GroupedSkuPromotion( 30, new HashSet<String>(Arrays.asList("C","D")))));
		
	}
	
	@RequestMapping("/orderTotal")
	public double findOrderTotal() {
		return service.findOrderTotal(cart);
	}
	
	
	
}
