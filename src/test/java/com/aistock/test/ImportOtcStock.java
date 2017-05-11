package com.aistock.test;

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
import com.aistock.analyst.entity.OtcStock;
import com.aistock.analyst.imports.ImportDailyStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.FinanceStockRepository;
import com.aistock.analyst.repository.OtcStockRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class ImportOtcStock {
	
	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);

	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Autowired
	OtcStockRepository otcStockRepository;
	
	
	@Test
	public void test001() throws Exception {
		
		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");
		
		for (final File file : folder.listFiles()) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));
			
			String stockNum = (file.getName().split("\\."))[0].split("_")[1];
			
			log.info(stockNum);
			
			String stockName = dailyStockRepository.findByStockNum(stockNum).get(0).getStockName();
			
			OtcStock o = new OtcStock();
			
			o.setOtcStockId(stockNum);
			o.setEnabled(false);
			o.setStockName(stockName);
			o.setWeight(100);
			o.setNote("");
			
			otcStockRepository.save(o);
			
			
		}
		
	}
}
