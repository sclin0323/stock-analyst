package com.aistock.analyst.statistics;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.creater.CreaterFinance;
import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.entity.Statistics003;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.Statistics003Repository;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class Statistics003Creater {

	Logger log = LoggerFactory.getLogger(Statistics003Creater.class);

	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;

	@Autowired(required = true)
	Statistics003Repository statistics003Repository;

	@Test
	public void test001() throws ParseException {

		statistics003Repository.deleteAll();
		
		
		
		// 持續買超
		statistics003Repository.save(getStatistics003("持續買超", "DIF持續走多", "季上"));
		statistics003Repository.save(getStatistics003("持續買超", "DIF持續走多", "季下"));

		statistics003Repository.save(getStatistics003("持續買超", "DIF由多轉空", "季上"));
		statistics003Repository.save(getStatistics003("持續買超", "DIF由多轉空", "季下"));

		statistics003Repository.save(getStatistics003("持續買超", "DIF持續走空", "季上"));
		statistics003Repository.save(getStatistics003("持續買超", "DIF持續走空", "季下"));

		statistics003Repository.save(getStatistics003("持續買超", "DIF由空轉多", "季上"));
		statistics003Repository.save(getStatistics003("持續買超", "DIF由空轉多", "季下"));

		// 由賣轉買
		statistics003Repository.save(getStatistics003("由賣轉買", "DIF持續走多", "季上"));
		statistics003Repository.save(getStatistics003("由賣轉買", "DIF持續走多", "季下"));

		statistics003Repository.save(getStatistics003("由賣轉買", "DIF由多轉空", "季上"));
		statistics003Repository.save(getStatistics003("由賣轉買", "DIF由多轉空", "季下"));

		statistics003Repository.save(getStatistics003("由賣轉買", "DIF持續走空", "季上"));
		statistics003Repository.save(getStatistics003("由賣轉買", "DIF持續走空", "季下"));

		statistics003Repository.save(getStatistics003("由賣轉買", "DIF由空轉多", "季上"));
		statistics003Repository.save(getStatistics003("由賣轉買", "DIF由空轉多", "季下"));

		// 由買轉賣
		statistics003Repository.save(getStatistics003("由買轉賣", "DIF持續走多", "季上"));
		statistics003Repository.save(getStatistics003("由買轉賣", "DIF持續走多", "季下"));

		statistics003Repository.save(getStatistics003("由買轉賣", "DIF由多轉空", "季上"));
		statistics003Repository.save(getStatistics003("由買轉賣", "DIF由多轉空", "季下"));

		statistics003Repository.save(getStatistics003("由買轉賣", "DIF持續走空", "季上"));
		statistics003Repository.save(getStatistics003("由買轉賣", "DIF持續走空", "季下"));

		statistics003Repository.save(getStatistics003("由買轉賣", "DIF由空轉多", "季上"));
		statistics003Repository.save(getStatistics003("由買轉賣", "DIF由空轉多", "季下"));

		// 持續賣超
		statistics003Repository.save(getStatistics003("持續賣超", "DIF持續走多", "季上"));
		statistics003Repository.save(getStatistics003("持續賣超", "DIF持續走多", "季下"));

		statistics003Repository.save(getStatistics003("持續賣超", "DIF由多轉空", "季上"));
		statistics003Repository.save(getStatistics003("持續賣超", "DIF由多轉空", "季下"));

		statistics003Repository.save(getStatistics003("持續賣超", "DIF持續走空", "季上"));
		statistics003Repository.save(getStatistics003("持續賣超", "DIF持續走空", "季下"));

		statistics003Repository.save(getStatistics003("持續賣超", "DIF由空轉多", "季上"));
		statistics003Repository.save(getStatistics003("持續賣超", "DIF由空轉多", "季下"));
		
		

	}

	
	private Statistics003 getStatistics003(String investStatus, String difStatus, String monthStatus)
			throws ParseException {

		// 過濾成交量30天要超過30000張
		List<DailyStock> datas = dailyStockRepository.findByDifStatusAndMonthStatusContainingAndForeignInvestIn30DaysStatusAndVolumeInvestIn30DaysGreaterThan(difStatus, monthStatus, investStatus, 30000L);
		//Sort sort = new Sort(Direction.DESC, "volumeInvestIn30Days");
		//Pageable pageable = new PageRequest(0, 85000, sort);
		//Page<DailyStock> datas = dailyStockRepository.findByDifStatusAndMonthStatusContainingAndForeignInvestIn30DaysStatusAndVolumeInvestIn30DaysGreaterThanOrderByVolumeInvestIn30Days(difStatus, monthStatus, investStatus, 30000L, pageable);

		Integer upAfter25Days = 0;
		Integer downAfter25Days = 0;
		Integer up3_5perAfter25Days = 0;
		Integer down3_5perAfter25Days = 0;
		Integer up7perAfter25Days = 0;
		Integer down7perAfter25Days = 0;
		Integer up10perAfter25Days = 0;
		Integer down10perAfter25Days = 0;

		log.info(investStatus + " " + difStatus + " " + monthStatus + " Size:" + datas.size());

		// 25天
		Double sumRange = 0.0;
		for (DailyStock dailyStock : datas) {
			//log.info(dailyStock.getDate()+"_"+dailyStock.getStockNum()+"_"+dailyStock.getStockName()+"_"+dailyStock.getVolumeInvestIn30Days());

			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");

			String startDay = dailyStock.getDate();
			Date date = dt1.parse(startDay);
			// 計算 date 後25天
			Calendar specialDate = Calendar.getInstance();
			specialDate.setTime(date);
			specialDate.add(Calendar.DATE, 25);
			Date day = specialDate.getTime();
			String endDay = dt1.format(day);

			List<DailyStock> lists = dailyStockRepository.findByStockNumAndDateBetweenOrderByDateDesc(dailyStock.getStockNum(), startDay, endDay);

			if (lists.size() >= 1) {
				Double close = lists.get(0).getClose();
				Double range = (close - dailyStock.getClose()) /  dailyStock.getClose();
				sumRange = sumRange + range;
				if (range >= 0) {
					upAfter25Days++;
				} else {
					downAfter25Days++;
				}
				
				if(range >= 0.035) {
					up3_5perAfter25Days++;
				}
				
				if(range <= -0.035) {
					down3_5perAfter25Days++;
				}
				
				if(range >= 0.07) {
					up7perAfter25Days++;
				}
				
				if(range <= -0.07) {
					down7perAfter25Days++;
				}
				
				if(range >= 0.1) {
					up10perAfter25Days++;
				}
				
				if(range <= -0.1) {
					down10perAfter25Days++;
				}
			}
		}

		Statistics003 o = new Statistics003();
		o.setStatistics003Id(investStatus+difStatus+monthStatus);
		o.setInvestStatus(investStatus);
		o.setDifStatus(difStatus);
		o.setMonthStatus(monthStatus);
		o.setUpAfter25Days(upAfter25Days);
		o.setDownAfter25Days(downAfter25Days);
		o.setUp3_5perAfter25Days(up3_5perAfter25Days);
		o.setDown3_5perAfter25Days(down3_5perAfter25Days);
		o.setUp7perAfter25Days(up7perAfter25Days);
		o.setDown7perAfter25Days(down7perAfter25Days);
		o.setUp10perAfter25Days(up10perAfter25Days);
		o.setDown10perAfter25Days(down10perAfter25Days);
		o.setSumRange(sumRange);
		o.setTotal(datas.size());

		return o;
	}
	

}
