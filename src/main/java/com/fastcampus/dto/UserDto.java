package com.fastcampus.dto;

import com.fastcampus.domain.JobType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDto {

	@ApiModelProperty(value = "식별키", example = "0", required = true )
	private Long id;   // 식별키
	
	@ApiModelProperty(value = "아이디", example = "asdfw", required = true )
	private String username;    // 아이디
	
	@ApiModelProperty(value = "비밀번호", example = "1q2w3e4r", required = true )
	private String password;    // 비밀번호
	
	@ApiModelProperty(value = "이름", example = "홍길동", required = true )
	private String name;    // 이름

	@ApiModelProperty(value = "직업", example = "직장인", required = true )
	private JobType job;     // 직업

	@ApiModelProperty(value = "나이", example = "20", required = true )
	private int age;        // 나이
}

