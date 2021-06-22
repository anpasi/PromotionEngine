package com.promotion.api.service;

import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.request.UpdatePromotionsRequest;
import com.promotion.api.data.response.OrderResponse;

public interface PromotionEngineService {
	
	OrderResponse purchaseOrder(OrderRequest orderRequest);
	
	void updatePromotions(UpdatePromotionsRequest updatePromotionsRequest);
	
}