package com.Backend.taskproject.exception;

public class TaskNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public TaskNotFound(String msg){
		super(msg);
		this.msg = msg;
	}


}
