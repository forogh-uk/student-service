package com.schoolstudent.schoolstudent.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.schoolstudent.schoolstudent.entity.Activities;
import com.schoolstudent.schoolstudent.exception.ActivitiesNotFoundException;
import com.schoolstudent.schoolstudent.repository.ActivitiesRepository;

import jakarta.transaction.Transactional;

@Service
public class ActivitiesService {
	
	@Autowired
	private final ActivitiesRepository activitiesRepository;
	
	@Autowired
	private final StudentService studentService;

	public ActivitiesService(@Lazy ActivitiesRepository activitiesRepository,@Lazy StudentService studentService) {
		super();
		this.activitiesRepository = activitiesRepository;
		this.studentService = studentService;
	}
	

	
	//add activities
	
	public Activities addActivities(Activities activities) {
		return activitiesRepository.save(activities);
		
	}
	

	
	//get activities
	
	public List<Activities> getActivites(){
		return StreamSupport.stream(activitiesRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
	}
	
	//get activities by id
	
	public Activities getActivitie(int id) {
		return activitiesRepository.findById(id).orElseThrow(()->
				new ActivitiesNotFoundException(id));
	}
	
	//delete activities
	
	public Activities deletActivities(int id) {
		
		Activities deleteActivities= getActivitie(id);
		activitiesRepository.delete(deleteActivities);
		return deleteActivities;
		
	}
	
	//update activities
	//to edit in database we need Transactional
	@Transactional
	public Activities updateActivities(int id, Activities activities) {
		Activities updateActivities=getActivitie(id);
		updateActivities.setActivitiesname(activities.getActivitiesname());
		return updateActivities;
	}
	
	
	
	
}
