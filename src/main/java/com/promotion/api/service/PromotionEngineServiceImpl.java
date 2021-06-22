package com.promotion.api.service;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotion.api.data.common.Catalog;
import com.promotion.api.data.common.Product;
import com.promotion.api.data.common.Promotions;
import com.promotion.api.data.common.UnitOrder;
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
		
		for (UnitOrder unitOrder:orderRequest.getOrders()) {
			
			
			
			
		}
		

		//Check promotions

		//Calculate total amount of purchase order 

		orderResponse.setTotal(total);
		
		return orderResponse;
	}

}
