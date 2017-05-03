package com.aistock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.FutureStock;
import com.aistock.analyst.entity.Taiwan50Stock;
import com.aistock.analyst.imports.ImportDailyStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.FutureStockRepository;
import com.aistock.analyst.repository.Taiwan50StockRepository;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class InsertFutureStock {
	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);

	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Autowired
	Taiwan50StockRepository taiwan50StockRepository;

	@Test
	public void test001() throws Exception {
		
		/*
		for(String stockNum: StockStatus.WEIGHT_LIST) {
			
			String stockName = dailyStockRepository.findByStockNum(stockNum).get(0).getStockName();
			
			Taiwan50Stock o = new Taiwan50Stock();
			o.setTaiwan50StockId(stockNum);
			o.setEnabled(false);
			o.setStockName(stockName);
			o.setWeight(100);
			o.setNote("");
			
			
			taiwan50StockRepository.save(o);
		}
		*/
		
		
	}

}
