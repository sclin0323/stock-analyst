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
public class DashBoardCreater2 {

	Logger log = LoggerFactory.getLogger(DashBoardCreater2.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Autowired
	DashboardRepository dashboardRepository;

	@Autowired
	DailyStockRepository dailyStockRepository;

	@Test
	public void dashBoardCreater() throws Exception {

		dashboardRepository.deleteAll();

		List<DailyAveIndex> lists = dailyAveIndexRepository.findByName("加權指數");

		int i = 0;
		for (DailyAveIndex dailyAveIndex : lists) {
			
			log.info(dailyAveIndex.getDate());

			Thread t = new Thread(new Worker(dailyAveIndex));
			t.start();

			Thread.sleep(1000);

		}

	}

	private class Worker implements Runnable {

		DailyAveIndex dailyAveIndex;

		public Worker(DailyAveIndex dailyAveIndex) {
			this.dailyAveIndex = dailyAveIndex;
		}

		@Override
		public void run() {

			Dashboard o = new Dashboard();

			String date = dailyAveIndex.getDate();

			o.setDashboardId(date);
			o.setDay(getDay(dailyAveIndex.getDate()));
			o.setMonthStatus(dailyAveIndex.getMonthStatus());
			o.setDifStatus(dailyAveIndex.getDifStatus());
			o.setClose(dailyAveIndex.getClose());
			o.setRange(dailyAveIndex.getRange());
			o.setVolume(dailyAveIndex.getVolume());

			// 個股 FID狀態
			o.setStatusDifA(dailyStockRepository.findByDateAndDifStatus(date, StockStatus.DIF_STATUSA).size());
			o.setStatusDifB(dailyStockRepository.findByDateAndDifStatus(date, StockStatus.DIF_STATUSB).size());
			o.setStatusDifC(dailyStockRepository.findByDateAndDifStatus(date, StockStatus.DIF_STATUSC).size());
			o.setStatusDifD(dailyStockRepository.findByDateAndDifStatus(date, StockStatus.DIF_STATUSD).size());

			// 個股 月線狀態
			o.setStatusMonthA(dailyStockRepository.findByDateAndMonthStatus(date, StockStatus.MONTH_STATUSA).size());
			o.setStatusMonthB(dailyStockRepository.findByDateAndMonthStatus(date, StockStatus.MONTH_STATUSB).size());
			o.setStatusMonthC(dailyStockRepository.findByDateAndMonthStatus(date, StockStatus.MONTH_STATUSC).size());
			o.setStatusMonthD(dailyStockRepository.findByDateAndMonthStatus(date, StockStatus.MONTH_STATUSD).size());

			dashboardRepository.save(o);

		}
		
		private String getDay(String date) {

			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat dt2 = new SimpleDateFormat("E");
			Date d = null;
			try {
				d = dt1.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String day = dt2.format(d);
			return day;

		}

	}

}
