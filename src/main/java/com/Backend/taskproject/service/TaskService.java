package com.Backend.taskproject.service;

import java.util.List;

import com.Backend.taskproject.entity.Task;

public interface TaskService {

	Task saveTask(long userid, Task task);

	Task gettaskbyid(long id);
	
	public List<Task> getalltasks();
	
	

}
