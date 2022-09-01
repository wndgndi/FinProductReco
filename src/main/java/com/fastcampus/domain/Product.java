package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "product_id")
	private Long id; //기본키
  
	private float interestRate; //이율
	
	private String name; //상품 이름
	
	private long amount; //대출 금액
	
	private long repayPeriod; //상환기간
	
	private String agency; //대출 기관
	
	private Long cartCount; //장바구니 등록 수
	
	@Enumerated(EnumType.STRING)
	private JobType job; //직업
	
	private int age; //나이

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	// 생성메서드
	public static Product createProduct(float interestRate, long amount, long repayPeriod, String agency, Long cartCount, JobType job, int age) {
        Product product = new Product();
        product.setInterestRate(interestRate);
        product.setAmount(amount);
        product.setAgency(agency);
        product.setCartCount(cartCount);
        product.setJob(job);
        product.setAge(age);
        return product;
    }
	
	
	
}
