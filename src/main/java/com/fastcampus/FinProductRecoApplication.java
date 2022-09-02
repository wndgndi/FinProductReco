package com.fastcampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // Spring Audit를 이용한 생성 날짜와 수정 날짜를 저장
@SpringBootApplication
public class FinProductRecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinProductRecoApplication.class, args);
	}
}
