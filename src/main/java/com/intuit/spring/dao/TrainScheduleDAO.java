package com.intuit.spring.dao;

import java.util.List;

import com.intuit.spring.hbm.TrainScheduleMapping;

public interface TrainScheduleDAO {

	public List<TrainScheduleMapping> getAllSchedules();

	public List<TrainScheduleMapping> refreshSchedules() throws Exception;

	public List<TrainScheduleMapping> persistSchedules() throws Exception;

	public TrainScheduleMapping getScheduleForId(int id);

	public TrainScheduleMapping createSchedule(TrainScheduleMapping schedule);

	public TrainScheduleMapping updateSchedule(TrainScheduleMapping schedule);

	public TrainScheduleMapping deleteSchedule(int id);
	
	public boolean isScheduleExists(int id);
}
