package com.Backend.taskproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.serviceImpl.UserServiceImpl;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<Users>createUser(@RequestBody Users users){
		return new ResponseEntity<>(userServiceImpl.createUser(users),HttpStatus.CREATED);
	}

}