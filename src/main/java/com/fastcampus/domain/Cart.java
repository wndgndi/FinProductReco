package com.fastcampus.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long id;
	
	@OneToMany(mappedBy = "cart")
	private List<Product> products;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
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
}
