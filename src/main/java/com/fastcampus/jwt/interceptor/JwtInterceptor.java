package com.fastcampus.jwt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fastcampus.jwt.exception.UnauthorizedException;
import com.fastcampus.jwt.service.JwtService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
		
	private final JwtService jwtService;
	
	private static final String HEADER_AUTH = "Authorization";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		if (token != null && jwtService.isUsable(token)) {
			return true;
		} else {
			throw new UnauthorizedException();
		}
	}

}