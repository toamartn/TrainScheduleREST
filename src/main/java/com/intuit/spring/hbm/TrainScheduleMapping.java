package com.intuit.spring.hbm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TrainSchedule")
public class TrainScheduleMapping implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="TrainId")
	private Integer trainId;
	@Column(name="DeptTime")
	private Integer deptTime;
	
	public Integer getTrainId() {
		return trainId;
	}
	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}
	public Integer getDeptTime() {
		return deptTime;
	}
	public void setDeptTime(Integer deptTime) {
		this.deptTime = deptTime;
	}
	@Override
	public String toString() {
		return "TrainScheduleMapping [trainId=" + trainId + ", deptTime=" + deptTime + "]";
	}
}