package com.Backend.taskproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.repository.UserRepository;
import com.Backend.taskproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users createUser(@RequestBody Users users) {
		Users savedusers = userRepository.save(users);
		return savedusers;
	}
	
	

}
