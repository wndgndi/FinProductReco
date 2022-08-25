

package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fastcampus.persistence.CartRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
	
	private CartRepository cartRepository;
	
	@Id @GeneratedValue
    @Column(name = "cart_id")
	private Long id;
	
	@OneToOne(mappedBy = "delivery", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<>();
	
	// 편의 메소드
	// 객체에서 양방향 연관관계는 양쪽에 다 값을 세팅해야 하므로 편의 메소드로 한번에 세팅 
	public void addProduct(Product product) {
        products.add(product);
        product.setCart(this);
    }
	
	// 생성 메소드 
	// 서비스 레이어가 세터 대신 사용하도록 
	public static Cart createOrder(Product... products) {
		Cart cart = new Cart();
        for (Product product : products) {    
            cart.addProduct(product);
        }
        return cart;
    }
	
	// 비즈니스 메소드 (카트에서 삭제 -> 테이블의 변화)  
	public void cancel(Long id, Long count) {
		
		// 카트 테이블에서 삭제 
		cartRepository.deleteById(id);
		
		// Product의 cartCount -1
        for (Product product : products) {
            product.addCartCount(count);   
        }
    }
	
	

}
