package com.fastcampus.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	//username으로 객체 조회
	Optional<User> findByUsername(String username);
}
