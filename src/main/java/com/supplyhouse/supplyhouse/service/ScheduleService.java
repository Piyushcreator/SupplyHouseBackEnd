package com.supplyhouse.supplyhouse.service;

import java.util.List;

import com.supplyhouse.supplyhouse.model.Schedule;

public interface ScheduleService {
	public Schedule saveBooking(Schedule schedule);
	
	public List<Schedule> getAllBooking();
	
	public Schedule getBookingById(Integer id);
	
	public String deleteBooking(Integer id);
	
	public Schedule editBooking(Schedule schedule, Integer id);
}
