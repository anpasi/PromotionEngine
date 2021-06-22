package com.promotion.api.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.api.service.PromotionEngineService;

@RestController
public class PromotionEngineController {
	
	private PromotionEngineService service;
	
	@Autowired
	public PromotionEngineController(PromotionEngineService service) {
		super();
		this.service = service;
	}


}
