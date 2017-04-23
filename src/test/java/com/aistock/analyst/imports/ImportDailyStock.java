package com.aistock.analyst.imports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.bson.types.ObjectId;
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
import com.aistock.analyst.repository.DailyStockRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class ImportDailyStock {
	
	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);
	
	@Autowired
	DailyStockRepository dailyStockRepository;

	@Test
	public void importDailyStock() throws Exception{
		
		dailyStockRepository.deleteAll();
	
		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");
		
		for (final File file : folder.listFiles()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));
			
			log.info(file.getName());
			
			if(!file.getName().contains("個股日線追蹤")) {
				continue;
			}
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] strArray = line.replaceAll("\\s+", "").split(":");
				
				String date = strArray[0].split("\\.")[0];
				String stockNum = (file.getName()).split("\\.")[0].split("_")[1];
				String stockName = strArray[1];
				String monthStatus = strArray[2];
				String difStatus = strArray[3];
				Double range = Double.parseDouble(strArray[4]);
				Double close = Double.parseDouble(strArray[5]);
				Integer volume = (int)(Float.parseFloat(strArray[6]));
				
				DailyStock o = new DailyStock();
				
				o.setDailyStockId(new ObjectId());
				o.setDate(date);
				o.setStockNum(stockNum);
				o.setStockName(stockName);
				o.setMonthStatus(monthStatus);
				o.setDifStatus(difStatus);
				o.setRange(range);
				o.setClose(close);
				o.setVolume(volume);
				
				dailyStockRepository.save(o);
			}
			
		}
		
	}

}
