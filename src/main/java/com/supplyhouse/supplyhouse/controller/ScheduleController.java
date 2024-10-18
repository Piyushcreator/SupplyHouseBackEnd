package com.supplyhouse.supplyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.supplyhouse.supplyhouse.model.Schedule;
import com.supplyhouse.supplyhouse.service.ScheduleService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@PostMapping("/saveschedule")
	public ResponseEntity<?> saveSchedule(@RequestBody Schedule schedule){
		return new ResponseEntity<>(scheduleService.saveBooking(schedule),HttpStatus.CREATED);		
	}
	
	@GetMapping("/getallschedule")
	public ResponseEntity<?> getAllSchedule(){		
		return new ResponseEntity<>(scheduleService.getAllBooking(), HttpStatus.OK);
	}
	
	@GetMapping("/getschedule/{id}")
	public ResponseEntity<?> getSchedule(@PathVariable Integer id){		
		return new ResponseEntity<>(scheduleService.getBookingById(id), HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteschedule/{id}")
	public ResponseEntity<?> deleteSchedule(@PathVariable Integer id){		
		return new ResponseEntity<>(scheduleService.deleteBooking(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateschedule/{id}")
	public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule,@PathVariable Integer id){
		Schedule obj= scheduleService.editBooking(schedule,id);
		if(obj != null) {
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
		return new ResponseEntity<>("Server Error",HttpStatus.OK);
	}
}
