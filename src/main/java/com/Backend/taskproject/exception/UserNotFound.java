package com.Backend.taskproject.exception;

public class UserNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public UserNotFound(String msg){
		super(msg);
		this.msg = msg;
	}

	
}
