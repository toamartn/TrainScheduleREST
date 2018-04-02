package com.intuit.spring.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.intuit.spring.model.TrainSchedule;
import com.intuit.spring.model.TrainScheduleList;

public class MarshalUnMarshal {

	public static Map<Integer, TrainSchedule> getTrainSchedules() throws JAXBException, FileNotFoundException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(TrainScheduleList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		/*InputStream cacheFileInputStrem = MarshalUnMarshal.class.getResourceAsStream("/configuration/cache_data.xml");
		TrainScheduleList schedules = (TrainScheduleList) jaxbUnmarshaller.unmarshal(cacheFileInputStrem);*/
		
		TrainScheduleList schedules = (TrainScheduleList) jaxbUnmarshaller.unmarshal(new FileInputStream("c:/temp/schedules.xml"));
		Map<Integer, TrainSchedule> schedulesMap = schedules.getScheduleList().stream().collect(
				Collectors.toMap(x -> x.getTrainId(), x -> x));
		return schedulesMap;
	}

	public static void writeTrainSchedules(Map<Integer, TrainSchedule> scheduleMap) throws JAXBException, FileNotFoundException {
		
		TrainScheduleList schedules = new TrainScheduleList( new ArrayList<TrainSchedule>(scheduleMap.values()));

		JAXBContext jaxbContext = JAXBContext.newInstance(TrainScheduleList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
/*		URL url = MarshalUnMarshal.class.getResource("/configuration/cache_data.xml");
		jaxbMarshaller.marshal(schedules, new FileOutputStream(url.getPath(),false));
*/	
		jaxbMarshaller.marshal(schedules, new FileOutputStream("c:/temp/schedules.xml",false));
		}
	
	public static void main(String ar[]) throws Exception {
		// Map<Integer, TrainSchedule> scheduelMap = getTrainSchedules();
		
		URL url = MarshalUnMarshal.class.getResource("/configuration/cache_data.xml");
		System.out.println("PATH "+url.getPath());
		
		//System.out.println(scheduelMap);
	}
}