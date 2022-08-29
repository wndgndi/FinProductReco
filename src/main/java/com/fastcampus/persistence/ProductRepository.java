package com.fastcampus.persistence;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.JobType;
import com.fastcampus.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//상품 검색
	List<Product> findByNameContainsIgnoreCase(String keyword);
	
	//나이에 맞는 삼품 검색
	List<Product> findByAge(int age);
	
	//직업에 맞는 상품 검색
	List<Product> findByJob(JobType job);

	//랜덤 상품 출력
	@Query("select o from Product o where id in :ids")
	List<Product> findByRamdom(@Param("ids") HashSet<Integer> hashSet);
}
