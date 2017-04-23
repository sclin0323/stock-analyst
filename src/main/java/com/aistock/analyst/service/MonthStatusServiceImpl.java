package com.aistock.analyst.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.MonthStatus;
import com.aistock.analyst.repository.MonthStatusRepository;

@Service
public class MonthStatusServiceImpl implements MonthStatusService{
	
	Logger log = LoggerFactory.getLogger(MonthStatusServiceImpl.class);

	@Autowired
	MonthStatusRepository monthStatusRepository;

	@Override
	public MonthStatus create(MonthStatus obj) {
		
		obj.setMonthStatusId(new ObjectId());
		
		monthStatusRepository.save(obj);
	
		return obj;
		
	}
	
	

}
