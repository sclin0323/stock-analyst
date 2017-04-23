package com.aistock.analyst.service;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aistock.analyst.ImportDailyStock;
import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.repository.DailyStockRepository;

@Service
public class DailyStockServiceImpl implements DailyStockService{
	
	Logger log = LoggerFactory.getLogger(DailyStockServiceImpl.class);

	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Override
	public void create(String date, String stockName, String status, Double range, Double close, Integer volume) {
		
		DailyStock o = new DailyStock();
		
		o.setDailyStockId(new ObjectId());
		o.setDate(date);
		o.setStockName(stockName);
		o.setStatus(status);
		o.setRange(range);
		o.setClose(close);
		o.setVolume(volume);
		
		dailyStockRepository.save(o);
		
	}

	@Override
	public void test() {
		log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

}
