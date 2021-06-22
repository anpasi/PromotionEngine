package com.promotion.api.data.common;

import java.util.List;

/** DTO with the details of the promotion **/
public class UnitPromotion {
	
	private List<UnitOrder> unitOrder;
	private long promotionPrice;
	
	public List<UnitOrder> getUnitOrder() {
		return unitOrder;
	}
	public void setUnitOrder(List<UnitOrder> unitOrder) {
		this.unitOrder = unitOrder;
	}
	public long getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(long promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	
}
