package com.promotion.api.data.request;

import java.util.List;

import com.promotion.api.data.common.UnitPromotion;

public class UpdatePromotionsRequest {
	
	private List<UnitPromotion> promotions;

	public List<UnitPromotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<UnitPromotion> promotions) {
		this.promotions = promotions;
	}

}
