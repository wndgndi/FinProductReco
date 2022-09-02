package com.fastcampus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fastcampus.jwt.interceptor.JwtInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //접근 제한 없는 URI
	private static final String[] EXCLUDE_PATHS = {
			"/login",
            "/users",
            "/error/**",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/products",
            "/products/**"   
    };
    
    private final JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
						.addPathPatterns("/**")
						.excludePathPatterns(EXCLUDE_PATHS);
    }
}
