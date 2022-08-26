package com.fastcampus.service;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import com.fastcampus.domain.User;
import com.fastcampus.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	// 회원가입
	@Transactional
	public void insertUser(User user) {
		user.setRole("USER");
		userRepository.save(user);
	}
	
	// 유저 상세 조회
	@Transactional(readOnly = true)
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}
	
	// 회원 정보 수정
	@Transactional
	public void updateUser(User user) {
		User myUser = userRepository.findById(user.getId()).get();
		myUser.setJob(user.getJob());
		myUser.setName(user.getName());
		myUser.setPassword(user.getPassword());
	}
	
}
