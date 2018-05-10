package com.intuit.spring.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.spring.dao.TrainScheduleDAO;
import com.intuit.spring.hbm.TrainScheduleMapping;
import com.intuit.spring.model.TrainSchedule;

@Service
public class TrainScheduleService {
	
	@Autowired
	private TrainScheduleDAO scheduleDAO;

	public List<TrainSchedule> getAllSchedules() {
		
		List<TrainScheduleMapping> scheduleMapList = scheduleDAO.getAllSchedules();
		List<TrainSchedule> scheduleList = new ArrayList<TrainSchedule>();
		
		for(TrainScheduleMapping rec : scheduleMapList) {
			TrainSchedule schedule = new TrainSchedule();
			scheduleList.add(schedule);
			BeanUtils.copyProperties(rec, schedule);
		}
		return scheduleList;
	}

	public TrainSchedule getSchedule(int id) {
		TrainScheduleMapping scheduleMapping = scheduleDAO.getScheduleForId(id);
		TrainSchedule schedule = new TrainSchedule();
		BeanUtils.copyProperties(scheduleMapping, schedule);
		return schedule;
	}

	public TrainSchedule createSchedule(TrainSchedule schedule) {
		TrainScheduleMapping scheduleMapping = new TrainScheduleMapping();
		BeanUtils.copyProperties(schedule,scheduleMapping);
		scheduleMapping = scheduleDAO.createSchedule(scheduleMapping);
		BeanUtils.copyProperties(scheduleMapping, schedule);
		return schedule;
	}

	public TrainSchedule updateSchedule(TrainSchedule schedule) {
		
		if(schedule == null || !scheduleDAO.isScheduleExists(schedule.getTrainId()) ){
			System.out.println(scheduleDAO.isScheduleExists(schedule.getTrainId()));
			System.out.println("No record exist with id "+schedule.getTrainId());
			return null;
		}
		TrainScheduleMapping scheduleMapping = new TrainScheduleMapping();
		BeanUtils.copyProperties(schedule, scheduleMapping);
		scheduleMapping = scheduleDAO.updateSchedule(scheduleMapping);
		BeanUtils.copyProperties(scheduleMapping, schedule);
		return schedule;
	}

	public TrainSchedule deleteSchedule(int id) {
		TrainScheduleMapping scheduleMapping = scheduleDAO.deleteSchedule(id); 
		TrainSchedule schedule = new TrainSchedule();
		BeanUtils.copyProperties(scheduleMapping, schedule);
		return schedule;
	}
	
	public List<TrainSchedule> refreshSchedules( ) throws JAXBException, FileNotFoundException {
		return null;
	}
	
	public List<TrainSchedule> persistSchedules( ) throws FileNotFoundException, JAXBException {
		return null;
	}
}