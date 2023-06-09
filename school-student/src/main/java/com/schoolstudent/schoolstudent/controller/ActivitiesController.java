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
import org.springframework.web.bind.annotation.RestController;

import com.schoolstudent.schoolstudent.entity.Activities;
import com.schoolstudent.schoolstudent.entity.dto.ActivitiesDto;
import com.schoolstudent.schoolstudent.service.ActivitiesService;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

	
	@Autowired
    private final ActivitiesService activitiesService;
	

	
	
	public ActivitiesController(@Lazy ActivitiesService activitiesService) {
		super();
		this.activitiesService = activitiesService;
	}

	//retrive list of item
	
	@PostMapping
			public ResponseEntity<ActivitiesDto> addActivities(
					@RequestBody final ActivitiesDto  actrivitiesDto) 
			{
		Activities activities = activitiesService.addActivities(Activities.from(actrivitiesDto));
		return new ResponseEntity<>(ActivitiesDto.from(activities),HttpStatus.OK);
				
			}
	
	@GetMapping
	public ResponseEntity<List<ActivitiesDto>> getActivities(){
		List<Activities> activities = activitiesService.getActivites();
		//convert each activities into activities dto
		List<ActivitiesDto> activitiesDtos = activities.stream().map(ActivitiesDto::from)
				.collect(Collectors.toList());
		return new ResponseEntity<>(activitiesDtos,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<ActivitiesDto> getActivities(@PathVariable final int id){
		Activities activities = activitiesService.getActivitie(id);
		//convert activities to activities dto
		return new ResponseEntity<>(ActivitiesDto.from(activities),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<ActivitiesDto> deleteActivities(@PathVariable int  id){
		Activities activities = activitiesService.deletActivities(id);
		//convert to Active dto
		return new ResponseEntity<>(ActivitiesDto.from(activities),HttpStatus.OK);
	}
	
	//update activities
	
	@PutMapping("/id/{id}")
	public ResponseEntity<ActivitiesDto> updateActivities(@PathVariable int id, 
			@RequestBody ActivitiesDto activitiesDta){
		Activities activities = activitiesService.updateActivities(id, Activities.from(activitiesDta));
		return new ResponseEntity<>(ActivitiesDto.from(activities),HttpStatus.OK);
			
		
	}
	
}
