package com.fastcampus.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserDto {

private Long id;   // 식별키
	
	private String username;    // 아이디
	
	private String password;    // 비밀번호
	
	private String name;    // 이름
			
	private String job;     // 직업
	
	private int age;        // 나이

}

