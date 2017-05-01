package com.aistock.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");
		
		for (final File file : folder.listFiles()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));
			
			String stockNum = (file.getName().split("\\."))[0].split("_")[1];
			log.info(file.getName());
			
			if(!file.getName().contains("個股日線追蹤")) {
				continue;
			}
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] strArray = line.replaceAll("\\s+", "").split(":");
				
				String date = strArray[0].split("\\.")[0];
				String stockName = strArray[1];
				String monthStatus = strArray[2];
				String difStatus = strArray[3];
				Double range = Double.parseDouble(strArray[4]);
				Double close = Double.parseDouble(strArray[5]);
				Integer volume = (int)(Float.parseFloat(strArray[6]));
				
				Double difValue = Double.parseDouble(strArray[7]);
				Long foreignInvest = (long)Float.parseFloat(strArray[8]);
				Long foreignInvestIn30Days = (long)Float.parseFloat(strArray[9]);
				Long volumeInvestIn30Days = (long)Float.parseFloat(strArray[10]);
				String foreignInvestIn30DaysStatus = "";
				if(strArray.length == 12)
					foreignInvestIn30DaysStatus = strArray[11];
				
				log.info(date+" "+stockName+" "+Double.parseDouble(strArray[7])+" "+(long)Float.parseFloat(strArray[8]));
				
				DailyStock o = dailyStockRepository.findByDateAndStockNum(date, stockNum);
				
				if(o!= null) {
					o.setDifValue(difValue);
					o.setForeignInvest(foreignInvest);
					o.setForeignInvestIn30Days(foreignInvestIn30Days);
					o.setVolumeInvestIn30Days(volumeInvestIn30Days);
					o.setForeignInvestIn30DaysStatus(foreignInvestIn30DaysStatus);
					
					dailyStockRepository.save(o);
				}
				
				
				
				
			}
			
			//break;
			
		}
		
	}

}
