package com.intuit.spring.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TrainSchedule")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainSchedule {

	@XmlElement
	int trainId;
	@XmlElement
	int deptTime;

	public TrainSchedule(int trainId, int deptTime) {
		super();
		this.trainId = trainId;
		this.deptTime = deptTime;
	}

	public TrainSchedule() {
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public int getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(int deptTime) {
		this.deptTime = deptTime;
	}

	@Override
	public String toString() {
		return "TrainSchedule [trainId=" + trainId + ", deptTime=" + deptTime + "]";
	}
}
