package com.fastcampus.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fastcampus.domain.Product;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService productService;
	
	//찜 등록
	@PostMapping("/products/like/{id}")
	public void postLikeProduct(@PathVariable long id,@AuthenticationPrincipal UserDetailsImpl userDetails) {
		productService.postLikeProduct(id, userDetails);
	}
	
	//찜 등록 해제
	@DeleteMapping("/products/like/{id}")
	public void deleteLikeProduct(@PathVariable long id,@AuthenticationPrincipal UserDetailsImpl userDetails) {
		productService.deleteLikeProduct(id, userDetails);
	}
	
	//찜 목록 조회
	@GetMapping("/products/likes")
	public void getLikeProduct(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		List<Product> LikeProducts = productService.getLikeProducts(userDetails);
		model.addAttribute("LikeProducts", LikeProducts);
	}
	
	//모든 상품 조회
	@GetMapping("/products")
	public void getProductList(Model model) {
		model.addAttribute("products", productService.getProducts());
	}
	
	//상품 검색
	@GetMapping("/products/{keyword}")
	public void getSearchedProductList(@PathVariable String keyword, Model model) {
		model.addAttribute("SearchedProducts", productService.getSearchedProducts(keyword));
	}
	
	//유저별 추천 상품 출력
	@GetMapping("/products/recos")
	public void getProductList(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		List<Product> recoProducts= productService.getRecoProducts(userDetails);
		model.addAttribute("recoProducts", recoProducts);
	}
	
	
}
