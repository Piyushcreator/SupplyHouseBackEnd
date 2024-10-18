package com.supplyhouse.supplyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyhouse.supplyhouse.model.Schedule;
import com.supplyhouse.supplyhouse.repository.ScheduleRepository;

@Service
public class ScheduleServiceImp implements ScheduleService{
	@Autowired
	private ScheduleRepository scheduleRepo;
	
	@Override
	public Schedule saveBooking(Schedule schedule) {
	
		return scheduleRepo.save(schedule);
	}

	@Override
	public List<Schedule> getAllBooking() {
		
		return scheduleRepo.findAll();
	}

	@Override
	public Schedule getBookingById(Integer id) {
		
		return scheduleRepo.findById(id).get();
	}

	@Override
	public String deleteBooking(Integer id) {
		
		Schedule schedule= scheduleRepo.findById(id).get();
		if(schedule !=null) {
			scheduleRepo.delete(schedule);
			return "Schedule Deleted Successfully";
		}
		return "Something went wrong on server";
	}

	@Override
	public Schedule editBooking(Schedule schedule, Integer id) {
		
		Schedule oldschedule= scheduleRepo.findById(id).get();
		if(oldschedule !=null) {
		if(schedule.getDate()!=null) {
			oldschedule.setDate(schedule.getDate());
		}
		if(schedule.getStartTime()!=null) {
			oldschedule.setStartTime(schedule.getStartTime());
		}
		if(schedule.getEndTime()!=null) {
			oldschedule.setEndTime(schedule.getEndTime());
		}
		  return scheduleRepo.save(oldschedule);
		}
		else {
			return null;
		}
	}

}
