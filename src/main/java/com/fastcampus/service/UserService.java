package com.fastcampus.service;

import java.util.Objects;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Cart;
import com.fastcampus.domain.User;
import com.fastcampus.dto.UserDto;
import com.fastcampus.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	private static final String LOGIN_EXCEPTION_MSG = "로그인정보가 일치하지 않습니다.";
	private static final String USERNAME_EXIST_EXCEPTION_MSG = "이미 계정이 존재합니다.";
	
	//로그인
	@Transactional
	public UserDto login(String username, String password) {
		User user = userRepository.findByUsername(username).get();
		Objects.requireNonNull(user, LOGIN_EXCEPTION_MSG);
		
		if( ! this.isAccordPassword(user, password)){
			throw new IllegalStateException(LOGIN_EXCEPTION_MSG);
		}
		UserDto checkedUserDto = modelMapper.map(user, UserDto.class);
		
		return checkedUserDto;
	}
	
	//비밀번호 확인
	private boolean isAccordPassword(User user, String password){
		String encodedPassword = user.getPassword();
		return BCrypt.checkpw(password, encodedPassword);
	}

	//회원가입(아이디 유효성 검사, 비밀번호 암호화 추가)
	@Transactional
	public UserDto insertUser(UserDto userDto) {
		this.validate(userDto.getUsername());
		String encodedPassword =  BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()); //비밀번호 암호화
		userDto.setPassword(encodedPassword);
		User user = modelMapper.map(userDto, User.class);
		user.setCart(new Cart(user));
		userRepository.save(user);
		// 기본티 할당된 UserDto 리턴, 및 카트 생성
		User returnUser=userRepository.findByUsername(userDto.getUsername()).get(); 
		UserDto returnUserDto = modelMapper.map(returnUser, UserDto.class);
		return returnUserDto;
	}

	//아이디 유효성 검사
	public boolean isExist(String username) {
		boolean isExist = false;
		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()){
		    isExist = true;
		}
		return isExist;
	}
	
	//아이디 예외 처리
	public void validate(String username){
		if( this.isExist(username) ){
			throw new IllegalStateException(USERNAME_EXIST_EXCEPTION_MSG);
		}
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
	public UserDto updateUser(UserDto userDto, Long id) {  
		User myUser = userRepository.findById(id).get();  
		myUser.setJob(userDto.getJob());
		myUser.setName(userDto.getName());
		String encodedPassword =  BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
		myUser.setPassword(encodedPassword);
		userRepository.save(myUser);
		UserDto myUserDto = modelMapper.map(myUser, UserDto.class);
		return myUserDto;
	}
}
