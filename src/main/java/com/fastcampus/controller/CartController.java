package com.fastcampus.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.JobType;
import com.fastcampus.domain.Product;
import com.fastcampus.persistence.CartRepository;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartController {
	
	private final CartRepository cartRepository;
	
	@GetMapping("/carts")
    public List<CartDto> ordersV2() {
        List<Cart> carts = cartRepository.findAll();
        List<CartDto> result = carts.stream()
                .map(c -> new CartDto(c))
                .collect(Collectors.toList());

        return result;
    }

    @Getter
    static class CartDto {   
        private Long cartId;
        private List<ProductDto> products;

        public CartDto(Cart cart) {
            cartId = cart.getId();
            products = cart.getProducts().stream()    // DTO 안의 엔티티도 DTO로 변
                    .map(product -> new ProductDto(product))
                    .collect(Collectors.toList());
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
    }
	
}
