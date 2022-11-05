package com.organizationapp.cl.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class TaskException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;
	
	public TaskException(String message, HttpStatus httpStatus) {
		super(message);
		this.message=message;
		this.httpStatus=httpStatus;
	}
}
