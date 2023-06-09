package com.schoolstudent.schoolstudent.exception;

import java.text.MessageFormat;

public class ActivitiesNotFoundException extends RuntimeException {

	public ActivitiesNotFoundException(int id) {
		super(MessageFormat.format("Activities not found id : {0}", id));
		// TODO Auto-generated constructor stub
	}
	
	
	

}
