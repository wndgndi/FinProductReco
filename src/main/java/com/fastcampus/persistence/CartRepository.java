package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> { 
}