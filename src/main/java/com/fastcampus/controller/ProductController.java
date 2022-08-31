package com.fastcampus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.dto.ProductDto;
import com.fastcampus.service.ProductService;
import com.fastcampus.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"Product 정보를 제공하는 Controller"})
@RequiredArgsConstructor
@Controller
public class ProductController {
	
	private final ProductService productService;
	private final UserService userService;
	
	//모든 상품 조회
	@ApiOperation(value = "모든 상품 조회", notes = "등록된 모든 상품들을 조회한다.")
	@GetMapping("/products")
	@ResponseBody
	public List<ProductDto> getProductList() {
		return productService.getProducts();
	}
	
	//상품 검색
	@ApiOperation(value = "상품 검색", notes = "특정 키워드를 통해 상품을 검색한다.")
	@ApiImplicitParam(name = "keyword", value = "검색을 위한 특정 키워드", dataType = "String", paramType = "path")
	@GetMapping("/products/{keyword}")
	@ResponseBody
	public List<ProductDto> getSearchedProducts(@PathVariable String keyword) {
		return productService.getSearchedProducts(keyword);
	}
	
	//유저별 추천 상품 출력
	@ApiOperation(value = "추천 상품", notes = "회원에 따라 적합한 상품을 추천해준다.")
	@GetMapping("/products/recos/{id}")
	@ResponseBody
	public List<ProductDto> getRecoProducts(@PathVariable Long id) {
		return productService.getRecoProducts(userService.getUser(id));
	} 
	
	//주력 상품 랜덤 추천
	@ApiOperation(value = "랜덤 상품 추천", notes = "해당 기관의 주력 상품을 랜덤으로 추천해준다.")
	@GetMapping("/products/promotions")
	@ResponseBody
	public List<ProductDto> getPromoProducts(){
		return productService.getPromoProducts();
	}
	
	
}
