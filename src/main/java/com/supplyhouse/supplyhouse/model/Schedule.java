package com.supplyhouse.supplyhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "_id")
	private Integer id;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private String startTime;
	@Column(nullable = false)
	private String endTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Schedule(Integer id, String date, String startTime, String endTime) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	public Schedule() {
		super();
	}
	
	
}
