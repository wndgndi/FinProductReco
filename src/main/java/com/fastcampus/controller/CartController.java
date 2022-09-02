package com.fastcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fastcampus.dto.ProductDto;
import com.fastcampus.persistence.CartRepository;
import com.fastcampus.service.CartService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CartController {
	
	private final CartService cartService;
	private final CartRepository cartRepository;
	
//	// 카트에서 상품목록 조회
//	@GetMapping("/carts/{cartId}")
//	@ResponseBody
//	public List<ProductDto> getProducts(@PathVariable Long cartId) {
//		Optional<Cart> carts = cartRepository.findById(cartId);
//		List<CartProductDtoDto> collect = carts.stream().map(c -> new CartDto(c)).collect(Collectors.toList());
//
//		return new Result(collect);
//	}
//	
//	static class CartDto {
//		private Long cartId;
//		private List<ProductDto> products;
//
//		public CartDto(Cart cart) {
//			cartId = cart.getId();
//			products = cart.getProducts().stream() // DTO 안의 엔티티도 DTO로 변환
//					.map(product -> new ProductDto(product)).collect(Collectors.toList());
//		}
//	}

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
	@DeleteMapping("/carts/{cartId}/{productId}")
	public void deleteInCart(@PathVariable Long cartId, @PathVariable Long productId) {
		cartService.deleteInCart(cartId, productId);
	}

	// 카트 내 상품 모두 삭제
	@DeleteMapping("/carts/{cartId}")
	public void deleteAllInCart(@PathVariable Long cartId) {
		cartService.deleteAllInCart(cartId);
	}
}
