package com.schoolstudent.schoolstudent.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.schoolstudent.schoolstudent.entity.Activities;
import com.schoolstudent.schoolstudent.entity.Student;
import com.schoolstudent.schoolstudent.exception.StudentNotFoundException;
import com.schoolstudent.schoolstudent.service.ActivitiesService;
import com.schoolstudent.schoolstudent.service.StudentService;


@RestController
public class StudentControllerCopy {
	
	@Autowired
	private final StudentService studentService;
	
	@Autowired
	private final ActivitiesService activitiesService;
	

	
	

	public StudentControllerCopy(StudentService studentService, ActivitiesService activitiesService) {
		super();
		this.studentService = studentService;
		this.activitiesService = activitiesService;
	}
	
	/*

	@GetMapping("/students")
	public List<Student> findAllStudent(){
		return studentService.findAll();
	}
	
	@GetMapping("/findbyid/id/{id}")
	public EntityModel<Student> findById(@PathVariable int id) {
		Optional<Student> student=studentService.findById(id);
		
		if(student.isEmpty()) {
			throw new StudentNotFoundException("id" + id);
		}
		EntityModel<Student> entityModel=EntityModel.of(student.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllStudent());
		entityModel.add(link.withRel("all-student"));
		
		return entityModel;
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	  Student saveStudent = studentService.createStudent(student);
	  URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveStudent.getId())
				.toUri();
				
		//return the user url which is created
		return ResponseEntity.created(location ).build();
		
	}
	
	

	@GetMapping("/students/activities")
	public List<Activities> findAllActivities() {
		return activitiesService.findAll();
		
	}
	
	@GetMapping("/students/id/{id}/activities")
	public List<Activities> retrivieActivitiesForStudent(@PathVariable int id){
		Optional<Student> student = studentService.findById(id);
		
		if(student.isEmpty()) 
			throw new StudentNotFoundException("Student_ id: " + id);
		
		return student.get().getActivities();
		
	}
	
	@PostMapping("/students/id/{id}/activities")
	public ResponseEntity<Object> createActivitiesForStudent(@PathVariable int id,@RequestBody Activities activities) {
		   
		
		Optional<Student> student = studentService.findById(id);
		if(student.isEmpty())
			throw new StudentNotFoundException("student_id" + id);
		
		//we set student into the activities
		activities.setStudent(student.get());
		
		
		Activities saveActiveties = activitiesService.save(activities);
			
			//create a url for a new activiteis
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(saveActiveties.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	
*/
}
