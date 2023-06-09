package com.schoolstudent.schoolstudent.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolstudent.schoolstudent.entity.Student;
import com.schoolstudent.schoolstudent.entity.dto.StudentDto;
import com.schoolstudent.schoolstudent.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private final StudentService studentService;

	public StudentController(@Lazy StudentService studentService) {
		super();
		this.studentService = studentService;
	
	}
	
	//we have to post student to the database
	
	@PostMapping
	public ResponseEntity<StudentDto> addStudent(@RequestBody final  StudentDto studentDto) {
		Student student = studentService.addStudent(Student.from(studentDto));
		return new ResponseEntity<>(studentDto.from(student),HttpStatus.OK);
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<StudentDto>> getStudents() {
		
		List<Student> students = studentService.getStudents();
		//map student to student dto
		List<StudentDto> studentDto= students.stream().map(StudentDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(studentDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable final int id){
		Student student = studentService.getStudent(id);
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
		
	}
	
	@GetMapping("/getnameandactivities")
	public ResponseEntity<List<StudentDto>> getNameAndActivities(@RequestParam double gpa){
		List<Student> student = studentService.getNameAndActivitiesGpa(gpa);
		List<StudentDto> studentDto= student.stream().map(StudentDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(studentDto,HttpStatus.OK);
				
		
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<StudentDto> deleteStudent(@PathVariable final int id){
		Student student = studentService.deleteStudent(id);
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable final int id,
			                                        @RequestBody final StudentDto studentDto){
		Student student = studentService.editStudent(id,Student.from(studentDto));
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
	}
	
	//adding activities from student
	//we have to know which student and also which activities to add to student
	@PostMapping("/{studentid}/activities/{activitiesid}/add")
	public ResponseEntity<StudentDto> addActivitiesToStudent(@PathVariable final int studentid,
			                                                 @PathVariable final int activitiesid){
		Student student = studentService.addActivitiesToStudent(studentid, activitiesid);
		//convert student into student dto
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
		
	}
	
	
	
	//deleting activities from student
	
	@DeleteMapping("/{studentid}/activities/{activitiesid}/romove")
	public ResponseEntity<StudentDto> removeActivitiesForStudent(@PathVariable final int studentid,
                                                                 @PathVariable final int activitiesid){
		Student student = studentService.removeActivitieFromStudent(studentid, activitiesid);
		return new ResponseEntity<>(StudentDto.from(student),HttpStatus.OK);
	}
	
	
	

}
