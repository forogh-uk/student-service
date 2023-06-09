package com.schoolstudent.schoolstudent.entity;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolstudent.schoolstudent.entity.dto.StudentDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="Student_name")
	@JsonProperty("Student_name")
    private String name;
	@Column(name="Grade_Level")
    @JsonProperty("Grade_Level")
    private int gradeLevel;
    private double gpa;
    private String gender;
    @Column(name="note_Books")
    @JsonProperty("note_Books")
    private int noteBooks;
    
    
  //one student can have many activities -> one to many
  	//we dont want to show post in browser
  	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<Activities> activities= new ArrayList<>();
  	
    
 

    public Student(){

    }

	public Student(int id, String name, int gradeLevel, double gpa, String gender, int noteBooks,
			List<Activities> activities) {
		super();
		this.id = id;
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.noteBooks = noteBooks;
		this.activities = activities;
	}

	
    public int getNoteBooks() {

        return noteBooks;
    }

    public void setNoteBooks(int noteBooks) {
        this.noteBooks = noteBooks;
    }

   



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}

	public Student(String s) {
        this.name = s;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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



	public List<Activities> getActivities() {
		return activities;
	}



	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}



	public void printListOfActivities(){

        System.out.println("List of Activities are : " + this.activities);
    }



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender="
				+ gender + ", noteBooks=" + noteBooks + ", activities=" + activities + "]";
	}
	
	//add activities to activities collection
	public void addActivities(Activities activitie) {
		activities.add(activitie);
	}
	
	
	
	
	//remove activities
	public void removeActivities(Activities activitie) {
		activities.remove(activitie);
	}
	
	
	//use this for post method
	public static Student from(StudentDto studentDto) {
		Student student = new Student();
		student.setName(studentDto.getName());
		student.setGender(studentDto.getGender());
		student.setGpa(studentDto.getGpa());
		student.setNoteBooks(studentDto.getNoteBooks());
		return student;
	}
  


}
