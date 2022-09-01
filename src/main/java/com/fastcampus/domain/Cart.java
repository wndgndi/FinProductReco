package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
}
