package com.aistock.analyst.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.DifStatus;
import com.aistock.analyst.repository.DifStatusRepository;

@Service
public class DifStatusServiceImpl implements DifStatusService{
	
	Logger log = LoggerFactory.getLogger(DifStatusServiceImpl.class);

	@Autowired
	DifStatusRepository difStatusRepository;

	@Override
	public DifStatus create(DifStatus obj) {
		
		obj.setDifStatusId(new ObjectId());
		
		difStatusRepository.save(obj);
		
		return obj;
	}
	
	

}
