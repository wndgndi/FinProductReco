package com.fastcampus.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fastcampus.domain.Product;
import com.fastcampus.dto.ProductDto;
import com.fastcampus.dto.UserDto;
import com.fastcampus.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;
	
	//모든 상품 조회
	@Transactional(readOnly=true)
	public List<ProductDto> getProducts(){
		List<Product> products = productRepository.findAll();
		List<ProductDto> productDtos = products.stream().
				map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}
	
	//상품 검색
	@Transactional(readOnly=true)
	public List<ProductDto> getSearchedProducts(String keyword){
		List<Product> products = productRepository.findByNameContainsIgnoreCase(keyword);
		List<ProductDto> productDtos = products.stream().
				map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return productDtos;
	}
	
	//유저별 추천 상품 추천
	@Transactional(readOnly=true)
	public List<ProductDto> getRecoProducts(UserDto userDto){
		List<Product> recoProducts = new ArrayList<Product>();
		recoProducts.addAll(productRepository.findByJob(userDto.getJob()));
		recoProducts.addAll(productRepository.findByAge(userDto.getAge()));
		
		List<ProductDto> recoProductDtos = recoProducts.stream().
		map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		
		return recoProductDtos;
	}
	
	//주력 상품 랜덤 추천
	@Transactional(readOnly=true)
	public List<ProductDto> getPromoProducts(){
		HashSet<Long> nums = new HashSet<Long>(6);

		while(nums.size()<6){
			nums.add((long)(Math.random()*15));
		}

		List<Product> promoProducts = productRepository.findByRamdom(nums);
		List<ProductDto> promoProductDtos = promoProducts.stream().
				map(product -> modelMapper.map(product, ProductDto.class)).collect(Collectors.toList());
		return promoProductDtos;
	}
}
