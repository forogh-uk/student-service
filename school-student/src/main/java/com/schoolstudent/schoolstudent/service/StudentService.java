package com.schoolstudent.schoolstudent.service;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolstudent.schoolstudent.entity.Activities;
import com.schoolstudent.schoolstudent.entity.Student;
import com.schoolstudent.schoolstudent.exception.ActivitiesAlreadyAssignToStudent;
import com.schoolstudent.schoolstudent.exception.StudentNotFoundException;
import com.schoolstudent.schoolstudent.repsitory.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	@Autowired
	private final StudentRepository studentRepository;
	
	
	@Autowired
	private final ActivitiesService activitiesService;
	

	
	public StudentService(StudentRepository studentRepository, ActivitiesService activitiesService) {
		super();
		this.studentRepository = studentRepository;
		this.activitiesService = activitiesService;
	}


	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
		
	}
	
	
	public List<Student> getStudents() {
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
	}
	
	// we can use Optional or orElseThrow to pass exception if the student not in db
	
	public Student getStudent(int id) {
		
		return  studentRepository.findById(id).orElseThrow(()->
		new StudentNotFoundException(id));
		
	}
	
	//get student name and activities where student gpa >= 3
	
	public List<Student> getNameAndActivitiesGpa(double gpa) {
		
		
		List<Student> studentList =StreamSupport.stream(studentRepository.findByGpaGreaterThan(gpa)
				.spliterator(), false)
				 .collect(Collectors.toList()); 

		return studentList;
	}
	
	public Student deleteStudent(int id) {
		Student student = getStudent(id);
		studentRepository.delete(student);
		return student;
	}
	
	@Transactional
	public Student editStudent(int id, Student student) {
		Student studentToEdit = getStudent(id);
		//get name from browser and set to name in db
		studentToEdit.setName(student.getName());
		return studentToEdit;
		
		
	}
	
	//add activities to student
	@Transactional
		public Student addActivitiesToStudent(int studentId, int activitiesId) {
			
			//Retrieve student
			Student student = getStudent(studentId);
			Activities activities = activitiesService.getActivitie(activitiesId);
			//if activities is already assign to student
			if(Objects.nonNull(activities.getStudent())) {
				throw new ActivitiesAlreadyAssignToStudent(
						activitiesId, activities.getStudent().getId());
			}
			student.addActivities(activities);
			activities.setStudent(student);
			return student;
			
		}
		
		//delete activeties for student
	//we want to edit database and we did not use save method
	@Transactional
		
		public Student removeActivitieFromStudent(int studentId, int activitiesId) {
			//Retrieve student
			Student student = getStudent(studentId);
			Activities activities = activitiesService.getActivitie(activitiesId);
			student.removeActivities(activities);
			return student;
			
			
		}
	
	
	
	
	

}
