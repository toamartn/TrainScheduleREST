package com.intuit.spring.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.spring.model.TrainSchedule;
import com.intuit.spring.model.TrainScheduleList;
import com.intuit.spring.service.TrainScheduleService;

@Controller
@RequestMapping("/trainSchedule")
public class TrainTimeController {
	
	@Autowired(required=true)
	private TrainScheduleService trainScheduleService;
	
	private static final Log log = LogFactory.getLog(TrainTimeController.class);
	
	@PostMapping(value = "/create")
	public @ResponseBody TrainSchedule createSchedule(@RequestBody TrainSchedule schedule) {
		TrainSchedule scheduleResponse = trainScheduleService.createSchedule(schedule);
		return scheduleResponse;
	}

	@GetMapping(value = "/getAll")
	public @ResponseBody TrainScheduleList getAllSchedules() {
		log.info("got request for ");
		List<TrainSchedule> schedules = trainScheduleService.getAllSchedules();
		TrainScheduleList trainScheduleList = new TrainScheduleList();
		trainScheduleList.setScheduleList(schedules);
		return trainScheduleList;
	}

	@GetMapping(value = "/get/{id}")
	public @ResponseBody TrainSchedule getScheduleForId(@PathVariable ("id") int id) {
		log.info("got request for "+ id);
		TrainSchedule  schedule = trainScheduleService.getSchedule(id);
		return schedule;
	}

	@PutMapping(value = "/update/{id}")
	public @ResponseBody TrainSchedule updateSchedule(@RequestBody TrainSchedule schedule) {
		TrainSchedule scheduleResponse = trainScheduleService.updateSchedule(schedule);
		return scheduleResponse;
	}

	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody TrainSchedule deleteeSchedule(@PathVariable("id") int id) {
		TrainSchedule schedule = trainScheduleService.deleteSchedule(id);
		return schedule;
	}
	
	@GetMapping(value = "/refreshSchedules")
	public @ResponseBody TrainScheduleList refreshSchedules() throws JAXBException, FileNotFoundException {
		List<TrainSchedule> schedules = trainScheduleService.refreshSchedules();
		TrainScheduleList trainScheduleList = new TrainScheduleList();
		trainScheduleList.setScheduleList(schedules);
		return trainScheduleList;
	}
	
	@GetMapping(value = "/persistSchedules")
	public @ResponseBody TrainScheduleList persistSchedules() throws JAXBException, FileNotFoundException {
		List<TrainSchedule> schedules = trainScheduleService.persistSchedules();
		TrainScheduleList trainScheduleList = new TrainScheduleList();
		trainScheduleList.setScheduleList(schedules);
		return trainScheduleList;
	}
}