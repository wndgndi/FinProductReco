package com.fastcampus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id; //기본키
	
	private long interestRate; //이율
	
	private String name; //상품 이름
	
	private long amount; //대출 금액
	
	private long repayPeriod; //상환기간
	
	private int ageType; //나이
}
