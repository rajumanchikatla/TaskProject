package com.Backend.taskproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backend.taskproject.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
