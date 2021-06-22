package com.promotion.api.service;

import org.springframework.stereotype.Component;

import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.response.OrderResponse;

@Component
public class PromotionEngineServiceImpl implements PromotionEngineService {

	@Override
	public OrderResponse purchaseOrder(OrderRequest orderRequest) {
		
		OrderResponse orderResponse = new OrderResponse();

		
		
		
		return orderResponse;
	}

}
