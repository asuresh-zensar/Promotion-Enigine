package com.promotions.pricelist;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
	private static Map<String, Double> skus = new HashMap<>();

    static {
    	skus.put("A", 50.0);
    	skus.put("B", 30.0);
    	skus.put("C", 20.0);
    	skus.put("D", 15.0);
    }

    public static Double getPrice(String skuId) {
        return skus.get(skuId);
    }
	
}
