package com.fastcampus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.Product;
import com.fastcampus.dto.ProductDto;
import com.fastcampus.persistence.CartRepository;
import com.fastcampus.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	@Transactional
	public void addProduct(Long cartId, ProductDto productDto) {
		Cart findCart = cartRepository.findById(cartId).get();
		Product product = modelMapper.map(productDto, Product.class);	
		product.setCart(findCart);
		productRepository.save(product);
	}
	
	// 카트에서 삭제 
	@Transactional
    public void cancelCart(Long id, Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
    }
	
	// 카트 모든 내용 삭제
	@Transactional
	public void deleteAllCart() {}
}
