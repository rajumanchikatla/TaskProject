package com.Backend.taskproject.service;

import java.util.List;

import com.Backend.taskproject.playload.TaskDto;

public interface TaskService {
	
	public TaskDto saveTask(long userid,TaskDto taskDto);
	
	public List<TaskDto> getAllTasks(long userid);

	
	

}
