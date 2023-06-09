package com.schoolstudent.schoolstudent.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolstudent.schoolstudent.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByGpaGreaterThan(double gpa);

}
