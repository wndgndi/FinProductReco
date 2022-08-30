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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"User 정보를 제공하는 Controller"})
@RequiredArgsConstructor
@RestController
public class UserController {
	
	private final UserService userService;

	// 회원가입
	@ApiOperation(value = "회원가입", notes = "회원 정보를 받아서 새로운 회원을 등록한다.") // 해당 API에 대한 설명이나 설정
	@ApiImplicitParam(name = "userDto", value = "새로 추가되는 회원 정보", dataType = "UserDto")
	@PostMapping("/users")
	public void insertUser(@RequestBody UserDto userDto) {
		userService.insertUser(userDto);
	}
	
	// 회원 상세 조회
	@ApiOperation(value = "회원 상세 조회", notes = "회원의 Id를 통해 회원의 정보를 조회한다.")
	@ApiImplicitParam(name = "id", value = "회원 정보를 가져오기 위한 Id", dataType = "Long", paramType = "path")
	@GetMapping("/user/{id}")
	public UserDto getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	// 회원 정보 수정
	@ApiOperation(value = "회원 정보 수정", notes = "회원의 수정된 정보들을 받아서 수정한다.")
	@ApiImplicitParam(name = "userDto", value = "수정할 회원 정보", dataType = "userDto")
	@PutMapping("/user")
	public void updateUser(@RequestBody UserDto userDto) {
		 userService.updateUser(userDto);
	}
}