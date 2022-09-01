package com.fastcampus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.Product;
import com.fastcampus.dto.ProductDto;
import com.fastcampus.persistence.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final ModelMapper modelMapper;

	//카트 목록 조회
	@Transactional(readOnly=true)
	public List<ProductDto> getProducts(Long cartId){
		Cart findCart = cartRepository.findById(cartId).get();
		List<Product> products= findCart.getProducts();
		List<ProductDto> productDtos = products.stream().
				map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}
	
	//카트에 상품 추가
	@Transactional
	public void addProduct(Long cartId, ProductDto productDto) {
		Cart findCart = cartRepository.findById(cartId).get();
		Product product = modelMapper.map(productDto, Product.class);	
		List<Product> products = findCart.getProducts();
		products.add(product);
		cartRepository.save(findCart);
		
		for(Product pro: cartRepository.findById(cartId).get().getProducts()) {
			System.out.println(pro);
		}
	}

	// 카트에서 삭제
	@Transactional
	public void deleteInCart(Long cartId, Long productId) {
		Cart findCart = cartRepository.findById(cartId).get();
		findCart.getProducts().remove(productId.intValue());
		cartRepository.save(findCart);

		for(Product pro: cartRepository.findById(cartId).get().getProducts()) {
			System.out.println(pro);
		}
    }
	
	// 카트 모든 상품 삭제
	@Transactional
	public void deleteAllInCart(Long cartId) {
		Cart findCart = cartRepository.findById(cartId).get();
		findCart.getProducts().removeAll(findCart.getProducts());
		cartRepository.save(findCart);	
		
		for(Product pro: cartRepository.findById(cartId).get().getProducts()) {
			System.out.println(pro);
		}
	}
}
