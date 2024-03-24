package com.Backend.taskproject.service;

import java.util.List;

import com.Backend.taskproject.entity.Task;

public interface TaskService {
	
	public Task saveTask(long userid,Task task);
	
	public Task gettaskbyid(long userid);
	
	public List<Task> getalltasks(Long userid);
}
