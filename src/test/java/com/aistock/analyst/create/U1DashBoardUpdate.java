package com.aistock.analyst.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.aistock.analyst.repository.DailyAveIndexRepository;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DashboardRepository;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class U1DashBoardUpdate {

	Logger log = LoggerFactory.getLogger(U1DashBoardUpdate.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Autowired
	DashboardRepository dashboardRepository;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	

	@Test
	public void dashBoardCreater() throws Exception {

		List<DailyAveIndex> lists = dailyAveIndexRepository.findByName("加權指數");

		for (DailyAveIndex dailyAveIndex : lists) {
			
			String date = dailyAveIndex.getDate();
			
			// 檢查Dashboard是否已經存在
			if(dashboardRepository.findOne(date) != null) {
				log.info("存在!! "+date);
				continue;
			} 
			
			Dashboard o = new Dashboard();
			
			log.info(date);

			o.setDashboardId(date);
			o.setDay(getDay(dailyAveIndex.getDate()));
			o.setMonthStatus(dailyAveIndex.getMonthStatus());
			o.setDifStatus(dailyAveIndex.getDifStatus());
			o.setClose(dailyAveIndex.getClose());
			o.setRange(dailyAveIndex.getRange());
			o.setVolume(dailyAveIndex.getVolume());
			
			// 個股 DIF狀態
			o.setStatusDifA(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSA).size());
			o.setStatusDifB(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSB).size());
			o.setStatusDifC(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSC).size());
			o.setStatusDifD(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSD).size());

			// 個股 月線狀態
			o.setStatusMonthA(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSA).size());
			o.setStatusMonthB(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSB).size());
			o.setStatusMonthC(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSC).size());
			o.setStatusMonthD(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSD).size());

			dashboardRepository.save(o);

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
