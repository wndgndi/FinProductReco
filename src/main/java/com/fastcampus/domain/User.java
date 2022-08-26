
package com.fastcampus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	private String job;

	private String area;

	private int ageType;

	@OneToOne(fetch = FetchType.LAZY)
	private Cart cart;

}
