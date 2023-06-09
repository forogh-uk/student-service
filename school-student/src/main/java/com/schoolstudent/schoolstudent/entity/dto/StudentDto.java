package com.schoolstudent.schoolstudent.entity.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolstudent.schoolstudent.entity.Student;

import jakarta.persistence.Column;

public class StudentDto {
	private int id;
	private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private int noteBooks;
    
    private List<ActivitiesDto> activitiesDtos= new ArrayList<>();
    
    
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGradeLevel() {
		return gradeLevel;
	}
	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNoteBooks() {
		return noteBooks;
	}
	public void setNoteBooks(int noteBooks) {
		this.noteBooks = noteBooks;
	}
	
	
	
    
    
    public List<ActivitiesDto> getActivitiesDtos() {
		return activitiesDtos;
	}
	public void setActivitiesDtos(List<ActivitiesDto> activitiesDtos) {
		this.activitiesDtos = activitiesDtos;
	}
	
	
	public static StudentDto from(Student student) {
    	StudentDto studentDto = new StudentDto();
    	studentDto.setId(student.getId());
    	studentDto.setName(student.getName());
    	studentDto.setGender(student.getGender());
    	studentDto.setGpa(student.getGpa());
    	studentDto.setGradeLevel(student.getGradeLevel());
    	studentDto.setNoteBooks(student.getNoteBooks());
    	studentDto.setActivitiesDtos(student.getActivities().stream().map(ActivitiesDto::from)
    			.collect(Collectors.toList()));
    
    	return studentDto;
    	
    	
    	
    	
    }

}
