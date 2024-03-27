package com.Backend.taskproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GloblaExceptionHandler {

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<String> handleRuntimeException(RuntimeException e){
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("given id not found");
//	}
}
