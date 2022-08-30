package com.fastcampus.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.domain.Cart;
import com.fastcampus.persistence.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	
	// 카트에서 삭제 
	@Transactional
    public void cancelCart(Long id, Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
    }
}
