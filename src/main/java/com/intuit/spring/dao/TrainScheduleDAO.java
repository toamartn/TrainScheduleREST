package com.intuit.spring.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Repository;

import com.intuit.spring.model.TrainSchedule;
import com.intuit.spring.service.MarshalUnMarshal;

@Repository
public class TrainScheduleDAO {
	static Map<Integer, TrainSchedule> scheduleMap = new HashMap<Integer, TrainSchedule>();

	public TrainScheduleDAO() throws FileNotFoundException, JAXBException {
		scheduleMap = MarshalUnMarshal.getTrainSchedules();
	}
	
	public List<TrainSchedule> getAllSchedules() {
		List<TrainSchedule> schuduleList = new ArrayList<TrainSchedule>(scheduleMap.values());
		return schuduleList;
	}
	
	public List<TrainSchedule> refreshSchedules() throws JAXBException, FileNotFoundException {
		scheduleMap = MarshalUnMarshal.getTrainSchedules();
		return getAllSchedules();
	}
	
	public List<TrainSchedule> persistSchedules() throws JAXBException, FileNotFoundException {
		
		if(scheduleMap.size()>0) {
			System.out.println("scheduleMap size "+scheduleMap.size());
			MarshalUnMarshal.writeTrainSchedules(scheduleMap);
		}
		return getAllSchedules();
	}

	public TrainSchedule getScheduleForId(int id) {
		TrainSchedule schedule = scheduleMap.get(id);
		return schedule;
	}

	public TrainSchedule createSchedule(TrainSchedule schedule) {
		scheduleMap.put(schedule.getTrainId(), schedule);
		return scheduleMap.get(schedule.getTrainId());
	}

	public TrainSchedule updateSchedule(TrainSchedule schedule) {
		if (scheduleMap.get(schedule.getTrainId()) != null) {
			scheduleMap.get(schedule.getTrainId()).setDeptTime(schedule.getDeptTime());
		} else {
			scheduleMap.put(schedule.getTrainId(), schedule);
		}
		return scheduleMap.get(schedule.getTrainId());
	}

	public TrainSchedule deleteSchedule(int id) {
		TrainSchedule schedule = scheduleMap.remove(id);
		return schedule;
	}

}
