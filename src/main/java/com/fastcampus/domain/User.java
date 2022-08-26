package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class User extends BaseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //기본키
	
	private Long username; //유저네임
	
	private Long password; //비밀번호
	
	private String name; //유저 이름
	
	private String job; //유저 직업
	
	private int age; //유저 나이
	
	@OneToOne(fetch = FetchType.LAZY)
	private Cart cart;
}