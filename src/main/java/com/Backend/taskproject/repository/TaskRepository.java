package com.Backend.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.taskproject.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

	public List<Task> findByUsers_Id(Long userId);

}
