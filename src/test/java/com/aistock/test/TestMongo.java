package com.aistock.test;

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
		
		log.info("=============================");
		//List<DailyStock> datas = dailyStockRepository.findDateAndStockNumAll();
		//log.info("Size: "+datas.size());
	}
	
	
	
	

}
