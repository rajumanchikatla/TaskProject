package com.Backend.taskproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.playload.JWTAuthResponse;
import com.Backend.taskproject.playload.LoginDto;
import com.Backend.taskproject.security.JwtTokenProvider;
import com.Backend.taskproject.serviceImpl.UserServiceImpl;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/register")
	public ResponseEntity<Users>createUser(@RequestBody Users users){
		LOGGER.info("Auth controller postmapping running");
		return new ResponseEntity<>(userServiceImpl.createUser(users),HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse>loginUser(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JWTAuthResponse(token));	
		
	}

}
