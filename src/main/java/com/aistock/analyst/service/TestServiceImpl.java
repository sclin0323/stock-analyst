package com.aistock.analyst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.Test;
import com.aistock.analyst.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	TestRepository testRepository;
	
	@Override
	public void show() {
		
		Test t = new Test();
		t.setTestId("testId");
		t.setName("test name");
		
		testRepository.save(t);
		
		System.out.println("service...");
		
	}

}
