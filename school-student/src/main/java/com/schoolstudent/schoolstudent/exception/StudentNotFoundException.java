package com.schoolstudent.schoolstudent.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException(int id) {
		super(MessageFormat.format("Could not find the student with id: {0}", id));
		
	}

	
	
	
	

}
