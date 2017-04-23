package com.aistock.analyst.create;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.DailyAveIndex;
import com.aistock.analyst.repository.DailyAveIndexRepository;
import com.aistock.analyst.repository.DashboardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class DashBoardCreater {
	
	Logger log = LoggerFactory.getLogger(DashBoardCreater.class);
	
	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;
	
	@Autowired
	DashboardRepository dashboardRepository;

	@Test
	public void dashBoardCreater() throws Exception{
		
		List<DailyAveIndex> lists = dailyAveIndexRepository.findByName("加權指數");
		
		
		for(DailyAveIndex DailyAveIndex: lists) {
			
		}
		
		
		
	}
	

}
