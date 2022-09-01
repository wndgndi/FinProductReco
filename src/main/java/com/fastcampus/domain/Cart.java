package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private List<Product> products = new ArrayList<>();

	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private User user;
	
	//카트 생성자
	public Cart(User user) {
		this.user=user;
	}
	
	// 연관관계 편의 메소드
	public void addProduct(Product product) {
        products.add(product);
        product.setCart(this);
    }
	
	// 생성메서드
	public static Cart createCart(User user, Product... products) {
        Cart cart = new Cart();
        cart.setUser(user);
        for (Product product : products) {
            cart.addProduct(product);
        }
        return cart;
    }
}
