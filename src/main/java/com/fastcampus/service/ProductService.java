package com.fastcampus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Product;
import com.fastcampus.persistence.ProductRepository;
import com.fastcampus.security.jpa.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	//찜 등록
	@Transactional
	public void postLikeProduct(long id,  UserDetailsImpl userDetails) {
		List<Long> likeList =userDetails.getUser().getLikeList();
		likeList.add(id);
	}
	
	//찜 등록 해제
	@Transactional
	public void deleteLikeProduct(long id,  UserDetailsImpl userDetails) {
		List<Long> likeList =userDetails.getUser().getLikeList();
		likeList.remove(id);
	}
	
	//찜 목록 조회
	@Transactional(readOnly=true)
	public List<Product> getLikeProducts(UserDetailsImpl userDetails){
		List<Long> likeList =userDetails.getUser().getLikeList();
		return productRepository.findByLikeList(likeList);
	}
	
	//모든 상품 조회
	@Transactional(readOnly=true)
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	//상품 검색
	@Transactional(readOnly=true)
	public List<Product> getSearchedProducts(String keyword){
		return productRepository.findByNameContainsIgnoreCase(keyword);
	}
	
	//상품 추천
	@Transactional(readOnly=true)
	public List<Product> getRecoProducts(UserDetailsImpl userDetails){
		User user = userDetails.getUser();
		List<Product> recoProducts = new ArrayList<Product>();
		
		List<Product> recoJobProducts = productRepository.findByNameContainsIgnoreCase(user.getJob());
		List<Product> recoAreaProducts = productRepository.findByNameContainsIgnoreCase(user.getArea());
		List<Product> recoAgeTypeProducts = productRepository.findByAgeType(user.getAgetype());
		recoProducts.addAll(recoJobProducts); 
		recoProducts.addAll(recoAreaProducts);
		recoProducts.addAll(recoAgeTypeProducts); 
		return recoProducts;
	}
	
	
}
