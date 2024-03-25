package com.Backend.taskproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.taskproject.entity.Task;
import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.exception.UserNotFound;
import com.Backend.taskproject.repository.TaskRepository;
import com.Backend.taskproject.repository.UserRepository;
import com.Backend.taskproject.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Task saveTask(long userid, Task task) {
		// TODO Auto-generated method stub
		Users user = userRepository.findById(userid).orElseThrow(
				()-> new UserNotFound(String.format("User id %d not found", userid)) 
				);
		task.setUsers(user);
		Task savedtask = taskRepository.save(task);
		return savedtask;
	}

	@Override
	public Task gettaskbyid(long userid) {

		Optional<Task> taskoptional = taskRepository.findById(userid);
		if(taskoptional.isPresent()){
			return taskoptional.get();
		}else{
			throw new UserNotFound(String.format("User id %d not found", userid));
		}
		
	}

	public List<Task> getalltasks(Long userid){
       return taskRepository.findAll();
	}

	

}
