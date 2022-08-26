package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false)
	private Long id; //기본키

	@Column(name = "username", nullable = false, length = 50, unique = true)
	private String username; //유저네임

	@Column(name = "password", nullable = false)
	private String password; //비밀번호

	@Column(name = "name", nullable = false)
	private String name; //유저 이름

	@Column(name = "job")
	private String job; //유저 직업

	@Column(name = "age")
	private int age; //유저 나이
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CART_ID")
	private Cart cart;
}
