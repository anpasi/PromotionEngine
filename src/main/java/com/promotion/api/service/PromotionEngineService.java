package com.promotion.api.service;

import com.promotion.api.data.response.OrderResponse;

public interface PromotionEngineService {
	
	OrderResponse purchaseOrder(OrderResponse orderResponse);
	
}