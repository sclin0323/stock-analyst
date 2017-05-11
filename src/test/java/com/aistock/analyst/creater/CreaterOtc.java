package com.aistock.analyst.creater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.aistock.analyst.entity.DailyAveIndex;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.Otc;
import com.aistock.analyst.entity.OtcStock;
import com.aistock.analyst.repository.DailyAveIndexRepository;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.OtcRepository;
import com.aistock.analyst.repository.OtcStockRepository;
import com.aistock.analyst.status.StockStatus;

/*
 * 建立和更新金融(Finances) 統計表 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class CreaterOtc {

	Logger log = LoggerFactory.getLogger(CreaterOtc.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Autowired
	OtcRepository otcRepository;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Autowired
	OtcStockRepository otcStockRepository;
	

	@Test
	public void test001() throws Exception {
		
		List<OtcStock> fs = otcStockRepository.findAll();
		List<String> arrays = new ArrayList<String>();
		for(OtcStock o : fs) {
			arrays.add(o.getOtcStockId());
		}
		
		
		
		otcRepository.deleteAll();

		List<DailyAveIndex> lists = dailyAveIndexRepository.findByName("櫃買指數");

		for (DailyAveIndex dailyAveIndex : lists) {
			
			String date = dailyAveIndex.getDate();
			
			Otc o = new Otc();
			
			log.info(date);
			
			o.setOtcId(date);
			o.setDay(getDay(dailyAveIndex.getDate()));
			o.setMonthStatus(dailyAveIndex.getMonthStatus());
			o.setDifStatus(dailyAveIndex.getDifStatus());
			o.setClose(dailyAveIndex.getClose());
			o.setRange(dailyAveIndex.getRange());
			o.setVolume(dailyAveIndex.getVolume());
			
			// 個股 FID狀態
			o.setStatusDifA(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSA,arrays).size());
			o.setStatusDifB(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSB,arrays).size());
			o.setStatusDifC(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSC,arrays).size());
			o.setStatusDifD(dailyStockRepository.findByDateAndDifStatusAndStockNumIn(date,StockStatus.DIF_STATUSD,arrays).size());

			// 個股 月線狀態
			o.setStatusMonthA(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSA,arrays).size());
			o.setStatusMonthB(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSB,arrays).size());
			o.setStatusMonthC(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSC,arrays).size());
			o.setStatusMonthD(dailyStockRepository.findByDateAndMonthStatusAndStockNumIn(date,StockStatus.MONTH_STATUSD,arrays).size());

			otcRepository.save(o);
			
		}
		
		

	}
	
	@Test
	public void test002() throws Exception {
		List<Otc> lists = otcRepository.findAll();
		
		for(Otc o : lists) {
			// 後 2 3 14日實際漲跌點
			setValues(o);
			
			otcRepository.save(o);
		}
	}

	private String getDay(String date) throws ParseException {

		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dt2 = new SimpleDateFormat("E");
		Date d = dt1.parse(date);
		String day = dt2.format(d);
		return day;

	}
	
	private void setValues(Otc o) {

		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		try {
			String startDay = o.getOtcId();
			Date date = dt1.parse(startDay);
			// 計算 date 後14天
			Calendar specialDate = Calendar.getInstance();
			specialDate.setTime(date);
			specialDate.add(Calendar.DATE, 14);

			Date day = specialDate.getTime();
			String endDay = dt1.format(day);

			List<Otc> datas = otcRepository.findByOtcIdBetweenOrderByOtcIdDesc(startDay,
					endDay);

			if (datas.size() >= 4) {
				// 過濾近幾天的資料
				if (Integer.parseInt(datas.get(0).getOtcId()) - Integer.parseInt(startDay) < 5) {
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
