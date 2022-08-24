package com.fastcampus.security.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	//일반 객체를 받아 UserDetails 객체로 리턴(인가가 추가된 객체)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username).get();
		return new UserDetailsImpl(principal);
	}

	
	//회원가입
	@Transactional
	public User insertUser(User user) {
		user.setRole("USER");
		userRepository.save(user);
		return user; 
	}
	
	//회원 상세 조회
	@Transactional(readOnly = true)
	public User getUser(String username) {	
		Optional<User> findUser = userRepository.findByUsername(username);
		if(findUser.isPresent()) {
			return findUser.get();
		}
		return new User();		
	}

}
