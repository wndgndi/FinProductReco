package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;

@Entity
@Data @Setter
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

	@Enumerated(EnumType.STRING)    //  ORIGINAL : 컬럼이 숫자로 들어감 (디폴트) => 중간에 다른 상태 생기면 밀려서 사용안함 
	private JobType jobType;
	
	@Column(name = "name", nullable = false)
	private String name; //유저 이름

	private int age; //유저 나이
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CART_ID")
	private Cart cart;
}
