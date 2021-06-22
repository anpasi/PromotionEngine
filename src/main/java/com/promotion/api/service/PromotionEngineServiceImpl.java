package com.promotion.api.service;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotion.api.data.common.Catalog;
import com.promotion.api.data.common.Promotions;
import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.response.OrderResponse;

@Component
public class PromotionEngineServiceImpl implements PromotionEngineService {

	//List with current promotions
	private Promotions promotions;
	private Catalog catalog;

	public PromotionEngineServiceImpl() {

		try {
			File file = ResourceUtils.getFile("classpath:promotions.json");
			ObjectMapper mapper = new ObjectMapper();
			promotions = mapper.readValue(file,  Promotions.class);
			
			file = ResourceUtils.getFile("classpath:catalog.json");
			catalog = mapper.readValue(file,  Catalog.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}


	@Override
	public OrderResponse purchaseOrder(OrderRequest orderRequest) {

		OrderResponse orderResponse = new OrderResponse();
		
		long total = 0;



		//Check promotions

		//Calculate total amount of purchase order 

		orderResponse.setTotal(total);
		
		return orderResponse;
	}

}
