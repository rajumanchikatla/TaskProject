package com.Backend.taskproject.service;

import java.util.List;

import com.Backend.taskproject.entity.Task;

public interface TaskService {

	Task saveTask(long userid, Task task);

	Task getTaskByid(long id);
	
	public List<Task> getAllTasks();
	
	Task getTask(long userid,long taskid);
	
	void deleteTask(long userid,long taskid);

	

}
