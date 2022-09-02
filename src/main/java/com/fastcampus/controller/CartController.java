package com.fastcampus.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.dto.ProductDto;
import com.fastcampus.service.CartService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;

	// 카트에서 상품목록 조회
	@ApiOperation(value = "장바구니 상품 조회", notes = "장바구니의 상품 모두 조회한다.")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "cartId", value = "장바구니 아이디", dataType = "Long", paramType = "path", required = true))
	@GetMapping("/carts/{cartId}")
	@ResponseBody
	public List<ProductDto> getProducts(@PathVariable Long cartId) {
		return cartService.getProducts(cartId);
	}
	

	// 카트에 상품 등록
	@ApiOperation(value = "장바구니에 상품 추가", notes = "상품 정보를 가져와서 장바구니에 등록해준다.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cartId", value = "장바구니 아이디", dataType = "Long", paramType = "path", required = true),
			@ApiImplicitParam(name = "productDto", value = "상품 정보", dataType = "ProductDto", required = true) })
	@PostMapping("/product/cart/{cartId}")
	public void addProduct(@PathVariable Long cartId, @RequestBody ProductDto productDto) {
		cartService.addProduct(cartId, productDto);
	}

	// 카트 내 상품 하나 삭제
	@ApiOperation(value = "장바구니에 상품 삭제", notes = "장바구니에서 상품 하나를 삭제한다.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "cartId", value = "장바구니 아이디", dataType = "Long", paramType = "path", required = true),
			@ApiImplicitParam(name = "productId", value = "상품 아이디", dataType = "Long", paramType = "path", required = true) })
	@DeleteMapping("/carts/{cartId}/{productId}")
	public void deleteInCart(@PathVariable Long cartId, @PathVariable Long productId) {
		cartService.deleteInCart(cartId, productId);
	}

	// 카트 내 상품 모두 삭제
	@ApiOperation(value = "장바구니에 상품 모두 삭제", notes = "장바구니 내 모든 상품 삭제한다.")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "cartId", value = "장바구니 아이디", dataType = "Long", paramType = "path", required = true))
	@DeleteMapping("/carts/{cartId}")
	public void deleteAllInCart(@PathVariable Long cartId) {
		cartService.deleteAllInCart(cartId);
	}
}
