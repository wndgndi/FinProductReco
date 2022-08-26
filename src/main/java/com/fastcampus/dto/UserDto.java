package com.fastcampus.dto;

import lombok.Data;

@Data
public class UserDto {
	
	private Long id; //기본키
	
	private Long username; //유저네임
	
	private Long password; //비밀번호
	
	private String name; //유저 이름
	
	private String job; //유저 직업
	
	private int age; //유저 나이
}