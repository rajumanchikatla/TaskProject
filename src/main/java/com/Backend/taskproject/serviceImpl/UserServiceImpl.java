package com.Backend.taskproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.playload.UserDto;
import com.Backend.taskproject.repository.UserRepository;
import com.Backend.taskproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = userDtoToEntity(userDto);//converting userdto to users class to store the data
		Users savedUser = userRepository.save(user);
		return EntityTouserDto(savedUser);
	}
	
	private Users userDtoToEntity(UserDto userdto){
		Users users = new Users();
		users.setName(userdto.getName());
		users.setEmail(userdto.getEmail());
		users.setPassword(userdto.getPassword());
		return users;
	}
	private UserDto EntityTouserDto(Users savedUser){
		UserDto userDto = new UserDto();
		userDto.setId(savedUser.getId());
		userDto.setName(savedUser.getName());
		userDto.setEmail(savedUser.getEmail());
		userDto.setPassword(savedUser.getPassword());
		return userDto;
		
	}
	
	
	
	

}
