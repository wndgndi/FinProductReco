package com.fastcampus.dto;

import com.fastcampus.domain.JobType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductDto {

	@ApiModelProperty(value = "식별키", example = "0", required = true )
	private long id; //기본키
	
	@ApiModelProperty(value = "이율", example = "3.12", required = true )
	private long interestRate; //이율
	
	@ApiModelProperty(value = "상품명", example = "청년 대출", required = true )
	private String name; //상품 이름
	
	@ApiModelProperty(value = "대출 금액", example = "2000000", required = true )
	private long amount; //대출 금액
	
	@ApiModelProperty(value = "상환 기간", example = "150", required = true )
	private long repayPeriod; //상환기간
	
	@ApiModelProperty(value = "대출 기관", example = "국민은행", required = true )
	private String agency; //대출 기관
	
	@ApiModelProperty(value = "장바구니 등록 수", example = "20", required = true )
	private Long cartCount; //장바구니 등록 수
	
	@ApiModelProperty(value = "직업", example = "직장인", required = true )
	private JobType jop; //직업
	
	@ApiModelProperty(value = "나이", example = "21", required = true )
	private int age; //나이
}
