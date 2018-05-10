package com.intuit.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.spring.hbm.TrainScheduleMapping;

@Repository("TrainScheduleDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class TrainScheduleDAOHibImpl implements TrainScheduleDAO {

	@Autowired
	@Qualifier("sessionFactory")
	protected transient SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrainScheduleMapping> getAllSchedules() {

		return getSession().createCriteria(TrainScheduleMapping.class).list();
	}

	@Override
	public List<TrainScheduleMapping> refreshSchedules() throws Exception {
		return null;
	}

	@Override
	public List<TrainScheduleMapping> persistSchedules() throws Exception {
		return null;
	}

	@Override
	public TrainScheduleMapping getScheduleForId(int id) {

		Criteria criteria = getSession().createCriteria(TrainScheduleMapping.class);
		criteria.add(Restrictions.eq("trainId", id));
		TrainScheduleMapping schedule = (TrainScheduleMapping) criteria.uniqueResult();
		return schedule;
	}

	@Override
	public TrainScheduleMapping createSchedule(TrainScheduleMapping schedule) {
		System.out.println("Created a schedule " + getSession().save(schedule));
		return schedule;
	}

	@Override
	public TrainScheduleMapping updateSchedule(TrainScheduleMapping schedule) {
		getSession().update(schedule);
		return (TrainScheduleMapping)getSession().get(TrainScheduleMapping.class, schedule.getTrainId());
	}

	@Override
	public TrainScheduleMapping deleteSchedule(int id) {
		TrainScheduleMapping tsm = (TrainScheduleMapping)getSession().get(TrainScheduleMapping.class, new Integer(id));
		getSession().delete(tsm);
		return tsm;
	}

	@Override
	public boolean isScheduleExists(int id) {
		boolean isScheduleExists = false;
		Criteria criteria = getSession().createCriteria(TrainScheduleMapping.class);
		criteria.add(Restrictions.eq("trainId", id));
		isScheduleExists = criteria.uniqueResult() == null ? false : true;
		return isScheduleExists;
	}
	
	
}