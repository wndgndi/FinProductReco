package com.fastcampus.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.JobType;
import com.fastcampus.domain.Product;
import com.fastcampus.persistence.CartRepository;
import com.fastcampus.persistence.ProductRepository;
import com.fastcampus.service.CartService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartController {

	private final CartRepository cartRepository;
	private final CartService cartService;
	private final ProductRepository productRepository;

	// 카트에서 상품목록 조회
	@GetMapping("/carts/{cartId}")
	public Result carts(@PathVariable Long cartId) {
		Optional<Cart> carts = cartRepository.findById(cartId);
		List<CartDto> collect = carts.stream().map(c -> new CartDto(c)).collect(Collectors.toList());

		return new Result(collect);
	}

	@Data
	@AllArgsConstructor
	static class Result<T> { // json을 배열 타입이 아니라 객체 타입으로 반환시켜서 api 스펙 확장이 유연하도록
		private T data;
	}

	@Getter
	static class CartDto {
		private Long cartId;
		private List<ProductDto> products;

		public CartDto(Cart cart) {
			cartId = cart.getId();
			products = cart.getProducts().stream() // DTO 안의 엔티티도 DTO로 변환
					.map(product -> new ProductDto(product)).collect(Collectors.toList());
		}
	}

	@Data
	static class ProductDto {

		private float interestRate;
		private String name;
		private long amount;
		private long repayPeriod;
		private String agency;
		private Long cartCount;

		@Enumerated(EnumType.STRING)
		private JobType job;

		private int age;

		public ProductDto(Product product) {
			name = product.getName();
			interestRate = product.getInterestRate();
			amount = product.getAmount();
			repayPeriod = product.getRepayPeriod();
			agency = product.getAgency();
			cartCount = product.getCartCount();
			job = product.getJob();
			age = product.getAge();
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
		@DeleteMapping("/carts/{cartId}/{productId}")
		public void deleteInCart(@PathVariable Long cartId, @PathVariable Long productId) {
			cartService.deleteInCart(cartId, productId);
		}

		// 카트 내 상품 모두 삭제
		@DeleteMapping("/carts/{cartId}")
		public void deleteAllInCart(@PathVariable Long cartId) {
			cartService.deleteAllInCart(cartId);
		}

		/* 
		// 카트에 상품 등록
		@PostMapping("/cart")
		public Long cart(@RequestBody CreateProductRequest request) {

			Long id = cartService.cart(interestRate, amount, repayPeriod, agency, cartCount, job, age);
			return id;
		}

		@Data
		static class CreateProductRequest {
			Long usreId;
			float interestRate;
			long amount;
			long repayPeriod;
			String agency;
			Long cartCount;
			JobType job;
			int age;
		}
		*/
	}
}