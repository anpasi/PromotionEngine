package com.promotion.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.api.data.request.OrderRequest;
import com.promotion.api.data.response.OrderResponse;
import com.promotion.api.service.PromotionEngineService;

@RestController
public class PromotionEngineController {
	
	
	private PromotionEngineService service;
	
	@Autowired
	public PromotionEngineController(PromotionEngineService service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping(path = "/purchaseOrder", consumes = "application/json", produces = "application/json")
	public OrderResponse purchaseOrder(@RequestBody OrderRequest orderRequest) {
		
		return service.purchaseOrder(orderRequest);

	}
	
	

}
