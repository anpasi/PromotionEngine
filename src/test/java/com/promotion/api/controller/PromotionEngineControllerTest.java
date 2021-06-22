package com.promotion.api.controller;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.promotion.api.data.common.UnitOrder;
import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.response.OrderResponse;
import com.promotion.api.service.PromotionEngineService;

public class PromotionEngineControllerTest {
	
	@Mock
	private PromotionEngineService service;
	
	private PromotionEngineController controller;
	
	
	@BeforeAll
	public void initialize() {
		
		
		controller = new PromotionEngineController(service) ;
		
	}
	
	@Test
	public void testPurchaseOrderWhenNotNullRequest() {
		
		//Given 
		OrderRequest orderRequest = getOrderRequest() ;
		when(service.purchaseOrder(orderRequest)).thenReturn(getOrderResponse());
		
		//when 
		OrderResponse response = controller.purchaseOrder(orderRequest);
		
		//then 
		assertNotNull(response);
		
	}
	
	
	
	@Test
	public void testPurchaseOrderWhenNullRequest() {
		
		//Given 
		OrderRequest orderRequest = getOrderRequest() ;
		when(service.purchaseOrder(orderRequest)).thenReturn(null);
		
		//when 
		OrderResponse response = controller.purchaseOrder(null);
		
		//then 
		assertNull(response);
		
	}

	
	private OrderRequest getOrderRequest() {
		
		OrderRequest orderRequest = new OrderRequest();
		UnitOrder unitOrder = new UnitOrder();
		unitOrder.setIdProduct("A");
		unitOrder.setQuantity(1);
		
		List<UnitOrder> orders = new ArrayList<>();
		orders.add(unitOrder);
		orderRequest.setOrders(orders);
		
		return orderRequest;
	}
	
	
	private OrderResponse getOrderResponse() {
		
		OrderResponse response = new OrderResponse();
		response.setTotal(100);
		
		return response;
	}
}
