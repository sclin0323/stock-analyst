package com.aistock.analyst.create;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DailyAveIndexRepository;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DashboardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class U2StockDifSumUpdate {
	
	Logger log = LoggerFactory.getLogger(U1DashBoardUpdate.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Autowired
	DashboardRepository dashboardRepository;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	
	/*
	 * 更新 Dashboard 個股DIF狀態個數
	 */
	@Test
	public void test001() {
		
		List<Dashboard> lists = dashboardRepository.findAll();
		
		for(Dashboard o : lists) {
			// 後 2 3 14日實際漲跌點
			setValues(o);
			
			dashboardRepository.save(o);
		}
		
	}
	
	private void setValues(Dashboard o) {

		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		try {
			String startDay = o.getDashboardId();
			Date date = dt1.parse(startDay);
			// 計算 date 後14天
			Calendar specialDate = Calendar.getInstance();
			specialDate.setTime(date);
			specialDate.add(Calendar.DATE, 14);

			Date day = specialDate.getTime();
			String endDay = dt1.format(day);

			List<Dashboard> datas = dashboardRepository.findByDashboardIdBetweenOrderByDashboardIdDesc(startDay,
					endDay);

			if (datas.size() >= 4) {
				// 過濾近幾天的資料
				if (Integer.parseInt(datas.get(0).getDashboardId()) - Integer.parseInt(startDay) < 5) {
					return;
				}
				// 14天
				Double after14Days = datas.get(0).getClose() - o.getClose();
				o.setAfter14Days(after14Days.intValue());
				
				// 2天
				Double after2Days = datas.get(datas.size()-2).getClose() - o.getClose();
				o.setAfter2Days(after2Days.intValue());
				
				// 3天
				Double after3Days = datas.get(datas.size()-3).getClose() - o.getClose();
				o.setAfter3Days(after3Days.intValue());
				
				// 1天
				Double after1Days = datas.get(datas.size()-1).getClose() - o.getClose();
				o.setAfter1Days(after1Days.intValue());
				
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
