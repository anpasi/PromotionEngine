package com.promotion.api.data.request;

import java.util.List;

import com.promotion.api.data.common.UnitOrder;

/** DTO with the details for the request order  **/
public class OrderRequest {
	
	private List<UnitOrder> orders;

	public List<UnitOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<UnitOrder> orders) {
		this.orders = orders;
	}
	
}
