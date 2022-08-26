package com.fastcampus.service;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import com.fastcampus.domain.User;
import com.fastcampus.dto.UserDto;
import com.fastcampus.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	// 회원가입
	@Transactional
	public void insertUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		userRepository.save(user);
	}
	
	// 유저 상세 조회
	@Transactional(readOnly = true)
	public UserDto getUser(Long id) {
		User user = userRepository.findById(id).get();
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	// 회원 정보 수정
	@Transactional
	public void updateUser(UserDto userDto) {
		User myUser = userRepository.findById(userDto.getId()).get();
		myUser.setJob(userDto.getJob());
		myUser.setName(userDto.getName());
		myUser.setPassword(userDto.getPassword());
	}
	
}
