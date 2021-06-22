package com.promotion.api.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotion.api.data.common.Catalog;
import com.promotion.api.data.common.Product;
import com.promotion.api.data.common.Promotions;
import com.promotion.api.data.common.UnitOrder;
import com.promotion.api.data.common.UnitPromotion;
import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.response.OrderResponse;

@Component
public class PromotionEngineServiceImpl implements PromotionEngineService {

	//List with current promotions
	private Promotions promotions;
	private Catalog catalog;
	
	private Map<String, Long> products;

	public PromotionEngineServiceImpl() {

		try {
			File file = ResourceUtils.getFile("classpath:promotions.json");
			ObjectMapper mapper = new ObjectMapper();
			promotions = mapper.readValue(file,  Promotions.class);
			
			//Read available products
			file = ResourceUtils.getFile("classpath:catalog.json");
			catalog = mapper.readValue(file,  Catalog.class);
		
			//Prepare map with products
			products =  catalog.getProducts().stream().collect(Collectors.toMap(Product::getId, Product::getPrice, (a, b) -> b));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}


	@Override
	public OrderResponse purchaseOrder(OrderRequest orderRequest) {

		OrderResponse orderResponse = new OrderResponse();
		
		long total = 0;
		
		products =  catalog.getProducts().stream().collect(Collectors.toMap(Product::getId, Product::getPrice, (a, b) -> b));
		
		Map<String, Integer> purchasedProducts = new HashMap<>();
			
		//Process the orders. Lets calculate how many items are per product
		for (UnitOrder unitOrder:orderRequest.getOrders()) {
			Integer sum = purchasedProducts.getOrDefault(unitOrder.getIdProduct(), 0);
			sum+=unitOrder.getQuantity();
			purchasedProducts.put(unitOrder.getIdProduct(), sum);
		}
		
		Map<String, Integer> promotionsFoundInOrder = new HashMap<>();
		//Check promotions
		for (UnitPromotion unitPromotion:promotions.getPromotions()) {
			
			for (UnitOrder unitOrder: unitPromotion.getUnitOrder()) {
				
				//Get the current catalog of promotions. The promotion could contain more than one product
				Integer numberOfProducts = purchasedProducts.getOrDefault(unitOrder.getIdProduct(), 0);
				
				if (numberOfProducts==0 || numberOfProducts<unitOrder.getQuantity()) {
					//No enough products for this promotion
					break;
				}
				
				int promotionsFound = promotionsFoundInOrder.getOrDefault(unitPromotion.getId(), -1);
				
				int currentPromotion = numberOfProducts / unitOrder.getQuantity();
				
				if (promotionsFound==-1||promotionsFound>currentPromotion) {
					promotionsFoundInOrder.put(unitPromotion.getId(), currentPromotion);
				}
				
			}
			
			
			if (promotionsFoundInOrder.getOrDefault(unitPromotion.getId(), -1) != -1) {
				
				//Lets Calculate partial total
				
				
				//update map with products pending to process
				
			}
			
			
		}
		
		//Check the number of found promotions
		
		
		
		
		

		//Calculate total amount of purchase order 

		orderResponse.setTotal(total);
		
		return orderResponse;
	}

}
