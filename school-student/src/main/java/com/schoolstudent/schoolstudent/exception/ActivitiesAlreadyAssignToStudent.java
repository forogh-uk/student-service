package com.schoolstudent.schoolstudent.exception;

import java.text.MessageFormat;

public class ActivitiesAlreadyAssignToStudent extends RuntimeException {

	public ActivitiesAlreadyAssignToStudent(final int activitiesId, final int studentId) {
		super(MessageFormat.format("activities {0} is already assign to student{1}", activitiesId,studentId));
		
		
	}

	
	

}
