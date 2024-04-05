package com.Backend.taskproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.taskproject.entity.Task;
import com.Backend.taskproject.serviceImpl.TaskServiceImpl;

@RequestMapping("/api")
@RestController
public class TaskController {

	private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private TaskServiceImpl taskServiceImpl;

	@PostMapping("/{userid}/tasks")
	public ResponseEntity<Task> savetask(@PathVariable(name = "userid") long userid,
			@RequestBody Task task)
	{
		LOGGER.info("Task controller post mapping running");
		return new ResponseEntity<>(taskServiceImpl.saveTask(userid, task),HttpStatus.CREATED);
	}

	@GetMapping("/task")
	public List<Task>getAlltasks(){
		LOGGER.info("Task controller get mapping running");
		List<Task> alltasks = taskServiceImpl.getAllTasks();
		return alltasks;
	}

	@GetMapping("/task/{userid}")
	public ResponseEntity<?> getTaskbyid(@PathVariable long userid){
		LOGGER.info("Task Controller in Getmapping based on id");

		Task task = taskServiceImpl.getTaskByid(userid);
		return ResponseEntity.ok(task);
	}
	

	@GetMapping("/{userid}/tasks")
	public ResponseEntity<?> getUserAssignedTasks(@PathVariable(name = "userid") long userid) 
	{
		List<Task> task = taskServiceImpl.getAllTasks(userid);
		if(task.size()>0){
			LOGGER.info("Task controller Get mapping running"+	task.size());
			return new ResponseEntity<>(taskServiceImpl.getAllTasks(userid),HttpStatus.OK);
		}else{
			LOGGER.info("This userid with Task is not present"+ userid);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("User with ID has no assigned tasks.");
		}
	}

	@GetMapping("{userid}/tasks/{taskid}")
	public ResponseEntity<Task> getTask(
			@PathVariable long userid,
			@PathVariable long taskid){
		return new ResponseEntity<>(taskServiceImpl.getTask(userid, taskid),HttpStatus.OK);

	}
	
	
	
	@DeleteMapping("{userid}/tasks/{taskid}")
	public ResponseEntity<String> deleteTask(
			@PathVariable long userid,
			@PathVariable long taskid){
		taskServiceImpl.deleteTask(userid, taskid);
		return new ResponseEntity<String>("Task deleted succesfully",HttpStatus.OK);

	}


}
