package com.aistock.analyst.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.Statistics003;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DashboardRepository;
import com.aistock.analyst.repository.Statistics003Repository;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/statistics003")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class Statistics003Controller extends BaseController {
	Logger log = LoggerFactory.getLogger(Statistics003Controller.class);

	@Autowired(required = true)
	DashboardRepository dashboardRepository;
	
	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;
	
	@Autowired(required = true)
	Statistics003Repository statistics003Repository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		
		List<Statistics003> lists = statistics003Repository.findAll();
		
		
		return RestResponse.success(lists, lists.size());
		
		/*
		String status ="由賣轉買";
		
		List<DailyStock> ds = dailyStockRepository.findByForeignInvestIn30DaysStatus(status);
		
		log.info("Total Size:"+ds.size());
		List<DailyStock> datas = new ArrayList<DailyStock>();
		// 過濾後14天狀態要一致
		for(DailyStock o : ds) {
			log.info(o.getDate()+" "+o.getStockName());
			if(isStatusAfter14Days(o, "持續買超") == true) {
				datas.add(o);
			}
		}
		

		return RestResponse.success(datas, datas.size());
		*/
	}
	
	/*
	private Statistics003 getStatistics003(String investStatus, String difStatus, String monthStatus) throws ParseException {
		
		// 過濾成交量30天要超過8000張
		List<DailyStock> datas = dailyStockRepository.findByDifStatusAndMonthStatusAndForeignInvestIn30DaysStatusAndForeignInvestIn30DaysGreaterThan(difStatus, monthStatus, investStatus, 8000L);
		
		Integer upAfter16Days = 0;
		Integer downAfter16Days = 0;
		
		for(DailyStock dailyStock:datas) {
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
			
			String startDay = dailyStock.getDate();
			Date date = dt1.parse(startDay);
			// 計算 date 後16天
			Calendar specialDate = Calendar.getInstance();
			specialDate.setTime(date);
			specialDate.add(Calendar.DATE, 16);
			Date day = specialDate.getTime();
			String endDay = dt1.format(day);
			
			List<DailyStock> lists = dailyStockRepository.findByStockNumAndDateBetweenOrderByDateDesc(dailyStock.getStockNum(), startDay, endDay);
			if(lists.size() >= 1) {
				Double close = lists.get(0).getClose();
				if(close >= dailyStock.getClose()) {
					upAfter16Days++;
				} else {
					downAfter16Days++;
				}
			}
		}
		
		Statistics003 o = new Statistics003();
		o.setStatistics003Id(investStatus + difStatus + monthStatus);
		o.setInvestStatus(investStatus);
		o.setDifStatus(difStatus);
		o.setMonthStatus(monthStatus);
		o.setUpAfter16Days(upAfter16Days);
		o.setDownAfter16Days(downAfter16Days);
		o.setTotal(datas.size());
 		
		return o;
	}
	*/
	
	/*

	private boolean isStatusAfter14Days(DailyStock dailyStock, String status) throws ParseException {
		
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		
		String startDay = dailyStock.getDate();
		Date date = dt1.parse(startDay);
		// 計算 date 後14天
		Calendar specialDate = Calendar.getInstance();
		specialDate.setTime(date);
		specialDate.add(Calendar.DATE, 14);

		Date day = specialDate.getTime();
		String endDay = dt1.format(day);
		
		List<DailyStock> lists = dailyStockRepository.findByStockNumAndDateBetweenOrderByDateDesc(dailyStock.getStockNum(), startDay, endDay);
		
		for(DailyStock o :lists) {
			if(!status.equals(o.getForeignInvestIn30DaysStatus())) {
				return false;
			}
		}
		
		return true;
	}
	*/
	
	/*
	public static class Statistics003 {
		
		String statistics003Id;
		String investStatus;
		String difStatus;
		String monthStatus;
		Integer upAfter16Days;
		Integer downAfter16Days;
		Integer total;
		
		
		
		public String getStatistics003Id() {
			return statistics003Id;
		}
		public void setStatistics003Id(String statistics003Id) {
			this.statistics003Id = statistics003Id;
		}
		public String getMonthStatus() {
			return monthStatus;
		}
		public void setMonthStatus(String monthStatus) {
			this.monthStatus = monthStatus;
		}
		public String getInvestStatus() {
			return investStatus;
		}
		public void setInvestStatus(String investStatus) {
			this.investStatus = investStatus;
		}
		public String getDifStatus() {
			return difStatus;
		}
		public void setDifStatus(String difStatus) {
			this.difStatus = difStatus;
		}
		
		public Integer getUpAfter16Days() {
			return upAfter16Days;
		}
		public void setUpAfter16Days(Integer upAfter16Days) {
			this.upAfter16Days = upAfter16Days;
		}
		public Integer getDownAfter16Days() {
			return downAfter16Days;
		}
		public void setDownAfter16Days(Integer downAfter16Days) {
			this.downAfter16Days = downAfter16Days;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		
		
		
		
		
		
	}
	
	*/



}
