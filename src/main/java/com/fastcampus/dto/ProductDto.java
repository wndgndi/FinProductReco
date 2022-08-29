package com.fastcampus.dto;

import com.fastcampus.domain.JobType;

import lombok.Data;

@Data
public class ProductDto {

	private long id; //기본키
	
	private long interestRate; //이율
	
	private String name; //상품 이름
	
	private long amount; //대출 금액
	
	private long repayPeriod; //상환기간
	
	private String agency; //대출 기관
	
	private Long cartCount; //장바구니 등록 수
	
	private JobType jop; //직업
	
	private int age; //나이
}
