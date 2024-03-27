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
        Users user = userRepository.findById(userid)
                .orElseThrow(() -> new UserNotFound("User not found"));
        task.setUsers(user);
        return taskRepository.save(task);
    }

    @Override
    public Task gettaskbyid(long userid) {
        Optional<Task> taskOptional = taskRepository.findById(userid);
        return taskOptional.orElseThrow(() -> new UserNotFound("Task not found"));
    }

    public List<Task> getalltasks(){
       return taskRepository.findAll();
    }
	

    public List<Task> getAllTasks(long userid){
    	return taskRepository.findByUsers_Id(userid);
    }
    
//	public List<Task> getalltasks(Long userid){
//       return taskRepository.findAll();
//	}

    
}


