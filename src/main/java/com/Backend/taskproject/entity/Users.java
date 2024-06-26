package com.Backend.taskproject.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"email"})
})
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "email",nullable = false)
	private String email;

	@Column(name = "password",nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
	
}
