package com.intuit.spring.service;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.spring.dao.TrainScheduleDAO;
import com.intuit.spring.model.TrainSchedule;

@Service
public class TrainScheduleService {
	
	@Autowired
	private TrainScheduleDAO scheduleDAO;

	public List<TrainSchedule> getAllSchedules() {
		List<TrainSchedule> scheduleList = scheduleDAO.getAllSchedules();
		return scheduleList;
	}

	public TrainSchedule getSchedule(int id) {
		TrainSchedule schedule = scheduleDAO.getScheduleForId(id);
		return schedule;
	}

	public TrainSchedule createSchedule(TrainSchedule schedule) {
		TrainSchedule scheduleResponse = scheduleDAO.createSchedule(schedule);
		return scheduleResponse;
	}

	public TrainSchedule updateSchedule(TrainSchedule schedule) {
		TrainSchedule scheduleResponse = scheduleDAO.updateSchedule(schedule);
		return scheduleResponse;
	}

	public TrainSchedule deleteSchedule(int id) {
		TrainSchedule scheduleResponse = scheduleDAO.deleteSchedule(id);
		return scheduleResponse;
	}
	
	public List<TrainSchedule> refreshSchedules( ) throws JAXBException, FileNotFoundException {
		List<TrainSchedule> scheduleResponse = scheduleDAO.refreshSchedules();
		return scheduleResponse;
	}
	
	public List<TrainSchedule> persistSchedules( ) throws FileNotFoundException, JAXBException {
		List<TrainSchedule> scheduleResponse = scheduleDAO.persistSchedules();
		return scheduleResponse;
	}
}