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
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "USERS")
@EqualsAndHashCode(callSuper=false) //spring Audit 적용을 위한 설정
public class User extends BaseTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_Id", nullable = false)
	private Long id; //기본키

	private String username; //유저네임

	private String password; //비밀번호

	private String name; //유저 이름

	private String job; //유저 직업

	private int age; //유저 나이
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CART_ID")
	private Cart cart;
}
