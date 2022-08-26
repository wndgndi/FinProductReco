
package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String username;

	private Long password;

	private String name;

	@Enumerated(EnumType.STRING)    //  ORIGINAL : 컬럼이 숫자로 들어감 (디폴트) => 중간에 다른 상태 생기면 밀려서 사용안함 
	private JobType jobType;

	private String area;

	private int ageType;

	@OneToOne(fetch = FetchType.LAZY)
	private Cart cart;

}
