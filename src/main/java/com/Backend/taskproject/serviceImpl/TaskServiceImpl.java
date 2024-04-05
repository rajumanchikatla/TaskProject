package com.Backend.taskproject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.taskproject.entity.Task;
import com.Backend.taskproject.entity.Users;
import com.Backend.taskproject.exception.APIException;
import com.Backend.taskproject.exception.TaskNotFound;
import com.Backend.taskproject.exception.UserNotFound;
import com.Backend.taskproject.repository.TaskRepository;
import com.Backend.taskproject.repository.UserRepository;
import com.Backend.taskproject.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);

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
    public Task getTaskByid(long userid) {
        Optional<Task> taskOptional = taskRepository.findById(userid);
		LOGGER.info("Task Service get task by id");
        return taskOptional.orElseThrow(() -> new UserNotFound("Task not found"));
    }

    public List<Task> getAllTasks(){
       return taskRepository.findAll();
    }
	

    public List<Task> getAllTasks(long userid){
		LOGGER.info("Task Service get all tasks based on userid");
    	return taskRepository.findByUsers_Id(userid);
    }

	@Override
	public Task getTask(long userid, long taskid) {
		LOGGER.info("Task Service get all tasks based on userid and taskid");

		Users user = userRepository.findById(userid).orElseThrow(
				()->new UserNotFound(String.format("user id %d not found", userid)));
		Task task = taskRepository.findById(taskid).orElseThrow(
				()->new TaskNotFound(String.format("Task id %d not found", taskid)));	
		if(user.getId()!=task.getUsers().getId()){
			throw new APIException(String.format("Task id %d not belongs to user id %d", userid,taskid));
		}
			
		return task;
	}

	@Override
	public void deleteTask(long userid, long taskid) {
		// TODO Auto-generated method stub
		
		LOGGER.info("delete tasks based on userid and taskid");

		Users user = userRepository.findById(userid).orElseThrow(
				()->new UserNotFound(String.format("user id %d not found", userid)));
		Task task = taskRepository.findById(taskid).orElseThrow(
				()->new TaskNotFound(String.format("Task id %d not found", taskid)));	
		if(user.getId()!=task.getUsers().getId()){
			throw new APIException(String.format("Task id %d not belongs to user id %d", userid,taskid));
		}
		taskRepository.deleteById(taskid);  //task delete
		
	}
    

    
    

    
}


