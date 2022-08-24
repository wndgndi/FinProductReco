package com.fastcampus.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fastcampus.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	//찜한 상품 출력
	@Query("select o from Product o where id in :ids")
	List<Product> findByLikeList(@Param("ids") List<Long> likeList);

	//상품 검색
	List<Product> findByNameContainsIgnoreCase(String keyword);
	
	//나이에 맞는 삼품 검색
	List<Product> findByAgeType(int ageType);

}
