package com.fastcampus.dto;

import lombok.Data;

@Data
public class ProductDto {

	private long id; // 기본키

	private long interestRate; // 이율

	private String name; // 상품 이름

	private long amount; // 대출 금액

	private long repayPeriod; // 상환기간

	private int ageType; // 나이
}
