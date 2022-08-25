package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fastcampus.persistence.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {
	
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;

}
