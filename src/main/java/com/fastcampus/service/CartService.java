package com.fastcampus.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.Product;
import com.fastcampus.dto.ProductDto;
import com.fastcampus.persistence.CartRepository;
import com.fastcampus.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartRepository cartRepository;
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;

	
	//카트에 상품 추가  
	@Transactional public void addProduct(Long cartId, ProductDto productDto) {
	Cart findCart = cartRepository.findById(cartId).get(); Product product =
	modelMapper.map(productDto, Product.class);
	findCart.getProducts().add(product); cartRepository.save(findCart); }
	
	/* 
	// 카트에 상품 등록
	@Transactional
    public Long order(Long usreId, float interestRate, long amount, long repayPeriod, String agency, Long cartCount, JobType job, int age) {
        // 엔티티 조회
		User user = userRepository.findById(userId);
		//상품 생성
        Product product = Product.createProduct(interestRate, amount, repayPeriod, agency, cartCount, job, age);
        //카트 생성
        Cart cart = Cart.createCart(user, product);
        //카트 저장
        cartRepository.save(cart);
        return cart.getId();
    }
    */

	// 카트에서 삭제
	@Transactional
	public void deleteInCart(Long cartId, Long productId) {
		Cart findCart = cartRepository.findById(cartId).get();
		findCart.getProducts().remove(productId.intValue());
		cartRepository.save(findCart);
	}

	// 카트 모든 상품 삭제
	@Transactional
	public void deleteAllInCart(Long cartId) {
		Cart findCart = cartRepository.findById(cartId).get();
		findCart.getProducts().removeAll(findCart.getProducts());
		cartRepository.save(findCart);
	}

}
