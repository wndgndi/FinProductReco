package com.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.fastcampus.service.CartService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CartController {
	
	private CartService cartService;
	
	@DeleteMapping("/product/cart/{id}")
	public void deleteCart() {
		
	}

	@DeleteMapping("/product/cart")
	public void deleteAllCart() {
		
	}
}
