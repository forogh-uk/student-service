package com.schoolstudent.schoolstudent.entity.dto;

import com.schoolstudent.schoolstudent.entity.Activities;

import lombok.Data;

@Data
public class ActivitiesDto {
	
	private int id;
	private String activitiesname;
	
	
	
	
	
	//method to transfer activites to activitiesDTO object
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getActivitiesname() {
		return activitiesname;
	}


	public void setActivitiesname(String activitiesname) {
		this.activitiesname = activitiesname;
	}





	public static ActivitiesDto from(Activities activities) {
		ActivitiesDto activitiesDto= new ActivitiesDto();
		activitiesDto.setId(activities.getId());
		activitiesDto.setActivitiesname(activities.getActivitiesname());
		return activitiesDto;
	}
	

}
