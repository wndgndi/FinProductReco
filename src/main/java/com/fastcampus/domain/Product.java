

package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id;

	private String name;

	private Long interestDate;

	private Long amount;

	private Long repayPeriod;

	private String agency;

	private Long cartCount;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	// 비즈니스 로직
	//  cartCount 증가
	public void addCartCount(Long count) {
		this.cartCount += count;
    }
	
	// cartCount 감소
	public void removeCartCount(Long count) {
        Long restCount = this.cartCount - count;
        this.cartCount = restCount;
    }

}
