package com.Backend.taskproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Autowired
	private TaskServiceImpl taskServiceImpl;
	
	@PostMapping("/{userid}/tasks")
	public ResponseEntity<Task> savetask(@PathVariable(name = "userid") long userid,
										@RequestBody Task task)
	{
		return new ResponseEntity<>(taskServiceImpl.saveTask(userid, task),HttpStatus.CREATED);
	}
	
	@GetMapping("/task")
	public List<Task>getAlltasks(){
		List<Task> alltasks = taskServiceImpl.getalltasks();
		return alltasks;
	}
	
	@GetMapping("/task/{userid}")
	public ResponseEntity<?> getTaskbyid(@PathVariable long userid){
		Task task = taskServiceImpl.gettaskbyid(userid);
		return ResponseEntity.ok(task);
	}
	
	@GetMapping("/{userid}/tasks")
	 public ResponseEntity<?> getUserAssignedTasks(@PathVariable(name = "userid") long userid) {
        List<Task> task = taskServiceImpl.getAllTasks(userid);
        if(task.size()>0){
        	return new ResponseEntity<>(taskServiceImpl.getAllTasks(userid),HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID has no assigned tasks.");
                   }
       
    }
	
	
	
	
}
