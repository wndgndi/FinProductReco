package com.fastcampus.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Product;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService productService;
	
	//모든 상품 조회
	@GetMapping("/products")
	@ResponseBody
	public List<Product> getProductList() {
		return productService.getProducts();
	}
	
	//상품 검색
	@GetMapping("/products/{keyword}")
	@ResponseBody
	public List<Product> getSearchedProducts(@PathVariable String keyword) {
		return productService.getSearchedProducts(keyword);
	}
	
	//유저별 추천 상품 출력
	@GetMapping("/products/recos")
	@ResponseBody
	public List<Product> getRecoProducts(@AuthenticationPrincipal UserDetailsImpl userDetails) {
		return productService.getRecoProducts(userDetails);
	}
	
	//주력 상품 랜덤 추천
	@GetMapping("/products/promotions")
	@ResponseBody
	public List<Product> getPromoProducts(){
		return productService.getPromoProducts();
	}
	
}
