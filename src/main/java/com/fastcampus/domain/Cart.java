

package com.fastcampus.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cart {
	
	@Id @GeneratedValue
    @Column(name = "cart_id")
	private Long id;
	
	@OneToOne(mappedBy = "delivery", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<>();

}
