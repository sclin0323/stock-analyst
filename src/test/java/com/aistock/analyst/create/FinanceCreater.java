package com.aistock.analyst.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.aistock.analyst.entity.DailyAveIndex;
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.repository.DailyAveIndexRepository;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DashboardRepository;
import com.aistock.analyst.repository.FinanceRepository;
import com.aistock.analyst.status.StockStatus;

/*
 * 建立和更新金融(Finances) 統計表 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class FinanceCreater {

	Logger log = LoggerFactory.getLogger(FinanceCreater.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Autowired
	FinanceRepository financeRepository;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	

	@Test
	public void dashBoardCreater() throws Exception {
		
		List<String> fs = new ArrayList<String>();
		fs.add("2801");
		fs.add("2809");
		fs.add("2812");
		fs.add("2816");
		fs.add("2820");
		fs.add("2823");
		fs.add("2832");
		fs.add("2834");
		fs.add("2836");
		fs.add("2838");
		fs.add("2845");
		fs.add("2849");
		fs.add("2850");
		fs.add("2851");
		fs.add("2852");
		fs.add("2855");
		fs.add("2856");
		fs.add("2867");
		fs.add("2880");
		fs.add("2881");
		fs.add("2882");
		fs.add("2883");
		fs.add("2884");
		fs.add("2885");
		fs.add("2886");
		fs.add("2887");
		fs.add("2888");
		fs.add("2889");
		fs.add("2890");
		fs.add("2891");
		fs.add("2892");
		fs.add("5880");
		fs.add("6005");
		
		financeRepository.deleteAll();

		List<DailyAveIndex> lists = dailyAveIndexRepository.findByName("金融保險");

		for (DailyAveIndex dailyAveIndex : lists) {
			
			String date = dailyAveIndex.getDate();
			
			Finance o = new Finance();
			
			log.info(date);
			
			o.setFinanceId(date);
			o.setDay(getDay(dailyAveIndex.getDate()));
			o.setMonthStatus(dailyAveIndex.getMonthStatus());
			o.setDifStatus(dailyAveIndex.getDifStatus());
			o.setClose(dailyAveIndex.getClose());
			o.setRange(dailyAveIndex.getRange());
			o.setVolume(dailyAveIndex.getVolume());
			
			// 個股 FID狀態
			o.setStatusDifA(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSA,fs).size());
			o.setStatusDifB(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSB,fs).size());
			o.setStatusDifC(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSC,fs).size());
			o.setStatusDifD(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSD,fs).size());

			// 個股 月線狀態
			o.setStatusMonthA(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSA,fs).size());
			o.setStatusMonthB(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSB,fs).size());
			o.setStatusMonthC(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSC,fs).size());
			o.setStatusMonthD(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSD,fs).size());

			financeRepository.save(o);
			
		}
		
		

	}

	private String getDay(String date) throws ParseException {

		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dt2 = new SimpleDateFormat("E");
		Date d = dt1.parse(date);
		String day = dt2.format(d);
		return day;

	}
	


}
