package com.promotion.api.data.common;

import java.util.List;

/** DTO with the details of the promotion **/
public class UnitPromotion {
	
	private String id;
	
	private List<UnitOrder> unitOrder;
	private long promotionPrice;
	
	
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
