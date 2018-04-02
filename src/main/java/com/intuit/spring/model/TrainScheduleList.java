package com.intuit.spring.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TrainScheduleList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainScheduleList {

	@XmlElement(name = "TrainSchedule")
	private List<TrainSchedule> scheduleList;
	
	public TrainScheduleList(List<TrainSchedule> scheduleList) {
		super();
		this.scheduleList = scheduleList;
	}

	public TrainScheduleList() {
	}

	public List<TrainSchedule> getScheduleList() {
		return scheduleList;
	}

	public void setScheduleList(List<TrainSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
}
