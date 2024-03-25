package com.Backend.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.taskproject.entity.Task;
import com.Backend.taskproject.playload.TaskDto;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public List<TaskDto> getallTasks(long userid);

	public List<TaskDto> findAllById(Long userid);

}
