package com.aistock.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DashboardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class TestMongoLimit {
	
	Logger log = LoggerFactory.getLogger(TestMongoLimit.class);


	@Autowired
	DashboardRepository dashboardRepository;
	
	@Test
	public void test001() throws Exception {
		
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		Date date = dt1.parse("20170420");
		// 計算 date 後14天
		Calendar specialDate = Calendar.getInstance();
		specialDate.setTime(date);
		specialDate.add(Calendar.DATE, 14);
		
		Date day = specialDate.getTime();
		String endDay = dt1.format(day);
		
		log.info(endDay);
		
		List<Dashboard> datas = dashboardRepository.findByDashboardIdBetweenOrderByDashboardIdDesc("20170420",endDay);//
		
		for(Dashboard data : datas) {
			log.info(data.getDashboardId());
			
			
			
		}
		
		
		//log.info(o.getDashboardId());
		
		
		
	}

}
