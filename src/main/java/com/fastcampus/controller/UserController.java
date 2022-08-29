package com.fastcampus.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.dto.UserDto;
import com.fastcampus.jwt.JwtService;
import com.fastcampus.jwt.Result;
import com.fastcampus.service.UserService;

//import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

//@Api(tags = {"User 정보를 제공하는 Controller"})
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final JwtService jwtService;
	
	//로그인
	@PostMapping("/login")
	@ResponseBody
    public Result login(String username, String password, HttpServletResponse response){
    	Result result = Result.successInstance();
        UserDto loginMember = userService.login(username, password);
        String token = jwtService.create("user", loginMember);
        response.setHeader("Authorization", token);
        result.setData(loginMember);
        return result;
    }
	
	// 회원가입
	@PostMapping("/users")
	@ResponseBody
	public Result insertUser(@RequestBody UserDto userDto) {
		Result result = Result.successInstance();
		userService.insertUser(userDto);
		return result;
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
