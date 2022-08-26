package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;


import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false)
	private Long id;   // 식별키
	
	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String username;    // 아이디
	
	@Column(name = "password", nullable = false)
	private String password;    // 비밀번호
	
	@Column(name = "name", nullable = false)
	private String name;    // 이름
	
	@Column(name = "role")
	private String role;    // 권한
		
	@Column(name = "job")
	private String job;     // 직업
	
	@Column(name = "age")
	private int ageType;        // 나이
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CART_ID")
	private Cart cart;

}
