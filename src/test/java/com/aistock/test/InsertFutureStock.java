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
import com.aistock.analyst.imports.ImportDailyStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.FutureStockRepository;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class InsertFutureStock {
	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);

	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Autowired
	FutureStockRepository futureStockRepository;

	@Test
	public void test001() throws Exception {
		/*
		
		for(String stockNum: StockStatus.FUTURE_LIST) {
			
			String stockName = dailyStockRepository.findByStockNum(stockNum).get(0).getStockName();
			
			FutureStock o = new FutureStock();
			o.setFutureStockId(stockNum);
			o.setEnabled(false);
			o.setStockName(stockName);
			o.setWeight(100);
			o.setNote("");
			
			
			futureStockRepository.save(o);
		}
		*/
		
	}

}
