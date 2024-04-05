package com.Backend.taskproject.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter{

	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)
			throws ServletException, IOException {
		//get the token from headers 
		
		String token = getToken(request);
		//and check the token valid or not
		
	if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)){
		String email = jwtTokenProvider.getEmailFromToken(token);
		UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);
		UsernamePasswordAuthenticationToken authentication = new
				UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	
	}
		filterChain.doFilter(request, response);
		//load the user and setAuthentication
		
	
		
	}
	public String getToken(HttpServletRequest request){
		
		String token = request.getHeader("Authorization");
		if(StringUtils.hasText(token) && token.startsWith("Bearer")){
			return token.substring(7,token.length());
			
		}
		return null;
		
	}
	

}
