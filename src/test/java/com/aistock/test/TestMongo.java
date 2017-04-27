package com.aistock.test;

import java.util.ArrayList;
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
import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.imports.ImportDailyStock;
import com.aistock.analyst.repository.DailyStockRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class TestMongo {
	
Logger log = LoggerFactory.getLogger(ImportDailyStock.class);
	
	@Autowired
	DailyStockRepository dailyStockRepository;

	@Test
	public void test001() throws Exception{
		
		//String[] lists = new String["123","123"];
		
		//String[] lists = {"Cheese", "Pepperoni", "Black Olives"};
		
		List<String> lists = new ArrayList<String>();
		lists.add("1101");
		lists.add("1210");
		//lists.add("2345");
		
		
		List<DailyStock> datas = dailyStockRepository.findByDateAndMonthStatusAndStockNumIn("19980408", "月上季上", lists);
		
		log.info("Size: "+datas.size());
		
	}
	
	
	
	

}
