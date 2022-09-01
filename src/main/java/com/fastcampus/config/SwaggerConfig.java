package com.fastcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2 // 이 어노테이션을 붙이지 않으면 404 에러 발생, // Swagger2를 사용하겠다는 어노테이션
@Configuration
public class SwaggerConfig {

	// Swagger-UI에서 메인으로 보여질 내용을 설정
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("금융상품 추천")
				.description("금융상품 API")
				.contact(new Contact("[오리무중]", "https://www.notion.so/Back-End-52baed6a80da4976b416c7abe3be61ed", "wndgn456@gmail.com" ))
				.build();	
	}
	
	// Swagger 설정
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Mini Project")
				.apiInfo(this.apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fastcampus.controller")) // Swagger API 문서로 만들기 원하는 BasePackage 경로
				.paths(PathSelectors.any())  // basePackage로부터 매핑된 resource를 문서화 시킴
				.build();
	}
}
