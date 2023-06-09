package com.schoolstudent.schoolstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolstudent.schoolstudent.entity.dto.ActivitiesDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Activities {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="activitie_id")
	private int id;
	
	@Column(name="activitie_name")
    @JsonProperty("activities_name")
	@Size(min=3)
	private String activitiesname;
	
	//many activities for one student
		//fetch lazily or eager
		//if we want to retrieve activities and students in the same query ->eager
	
		@ManyToOne
		//@JsonIgnore
		private Student student;

	
	public Activities() {
			super();
			// TODO Auto-generated constructor stub
		}

	
	
	public Activities(int id, @Size(min = 3) String activitiesname) {
		super();
		this.id = id;
		this.activitiesname = activitiesname;
	}
	
	public static Activities from(ActivitiesDto activitiesDto) {
		Activities activities = new Activities();
		activities.setActivitiesname(activitiesDto.getActivitiesname());
		return activities;
	}
	
	
	



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}

	
	public String getActivitiesname() {
		return activitiesname;
	}
	public void setActivitiesname(String activitiesname) {
		this.activitiesname = activitiesname;
	}



	@Override
	public String toString() {
		return "Activities [id=" + id + ", activitiesname=" + activitiesname + ", student=" + student + "]";
	}
	
	
	
	
	

}
