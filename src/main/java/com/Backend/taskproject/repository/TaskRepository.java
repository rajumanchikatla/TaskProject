package com.Backend.taskproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.taskproject.entity.Task;
import com.Backend.taskproject.entity.Users;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllById(long userid);



	List<Task> findByUsers(Users user);

}
