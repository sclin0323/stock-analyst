package com.aistock.analyst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.service.DailyStockService;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class ImportDailyStock {
	
	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);
	
	@Autowired
	DailyStockService dailyStockService;
	
	@Autowired
	DailyStockRepository dailyStockRepository;

	@Test
	public void test001() throws Exception{
		
		dailyStockRepository.deleteAll();
	
		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");
		
		for (final File file : folder.listFiles()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));
			
			log.info(file.getName());
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] strArray = line.replaceAll("\\s+", "").split(":");
				
				String date = strArray[0].split("\\.")[0];
				String stockName = strArray[1];
				String status = strArray[2];
				Double range = Double.parseDouble(strArray[3]);
				Double close = Double.parseDouble(strArray[4]);
				Integer volume = (int)(Float.parseFloat(strArray[5]));
				
				dailyStockService.create(date, stockName, status, range, close, volume);
				
			}
			
			//break;
			
		}
		
	}

}
