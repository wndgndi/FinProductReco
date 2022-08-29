package com.fastcampus.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.dto.UserDto;
import com.fastcampus.jwt.JwtService;
import com.fastcampus.service.UserService;

//import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

//@Api(tags = {"User 정보를 제공하는 Controller"})
@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final JwtService jwtService;
	
	//로그인
	@PostMapping("/login")
	@ResponseBody
    public UserDto login(@RequestBody UserDto userDto, HttpServletResponse response){
        UserDto loginMember = userService.login(userDto.getUsername(), userDto.getPassword());
        String token = jwtService.create("user", loginMember); //토큰 생성
        response.setHeader("Authorization", token);
        System.out.println(token);
        return loginMember;
    }
	
	// 회원가입
	@PostMapping("/users")
	@ResponseBody
	public UserDto insertUser(@RequestBody UserDto userDto) {
		UserDto insertedUser = userService.insertUser(userDto);
		return insertedUser;
	}
	
	// 회원 상세 조회
	@GetMapping("/user/{id}")
	@ResponseBody
	public UserDto getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	// 회원 정보 수정
	@PutMapping("/user")
	@ResponseBody
	public void updateUser(@RequestBody UserDto userDto) {
		 userService.updateUser(userDto);
	}
}
