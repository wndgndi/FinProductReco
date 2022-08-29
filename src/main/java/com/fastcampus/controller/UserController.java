package com.fastcampus.controller;
	

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.dto.UserDto;
import com.fastcampus.service.UserService;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@Api(tags = {"User 정보를 제공하는 Controller"})
@RequiredArgsConstructor
@RestController
public class UserController {
	
	private final UserService userService;

	// 회원가입
	@PostMapping("/users")
	public void insertUser(@RequestBody UserDto userDto) {
		userService.insertUser(userDto);
	}
	
	// 회원 상세 조회
	@GetMapping("/user/{id}")
	public UserDto getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	// 회원 정보 수정
	@PutMapping("/user")
	public void updateUser(@RequestBody UserDto userDto) {
		 userService.updateUser(userDto);
	}
}
