package com.aistock.analyst.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DashboardRepository;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/statistics001")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class Statistics001Controller extends BaseController {
	Logger log = LoggerFactory.getLogger(Statistics001Controller.class);

	@Autowired(required = true)
	DashboardRepository dashboardRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String difStatus,
			String monthStatus) throws IOException {

		List<Statistics001> lists = new ArrayList<Statistics001>();

		lists.add(getStatistics001("DIF持續走多", "月上季上"));
		lists.add(getStatistics001("DIF持續走多", "月下季上"));
		lists.add(getStatistics001("DIF持續走多", "月下季下"));
		lists.add(getStatistics001("DIF持續走多", "月上季下"));

		lists.add(getStatistics001("DIF由多轉空", "月上季上"));
		lists.add(getStatistics001("DIF由多轉空", "月下季上"));
		lists.add(getStatistics001("DIF由多轉空", "月下季下"));
		lists.add(getStatistics001("DIF由多轉空", "月上季下"));

		lists.add(getStatistics001("DIF持續走空", "月上季上"));
		lists.add(getStatistics001("DIF持續走空", "月下季上"));
		lists.add(getStatistics001("DIF持續走空", "月下季下"));
		lists.add(getStatistics001("DIF持續走空", "月上季下"));

		lists.add(getStatistics001("DIF由空轉多", "月上季上"));
		lists.add(getStatistics001("DIF由空轉多", "月下季上"));
		lists.add(getStatistics001("DIF由空轉多", "月下季下"));
		lists.add(getStatistics001("DIF由空轉多", "月上季下"));

		return RestResponse.success(lists, lists.size());
	}

	private Statistics001 getStatistics001(String difStatus, String monthStatus) {

		List<Dashboard> datas = dashboardRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus);

		Statistics001 o = new Statistics001();
		o.setStatistics001Id(difStatus + monthStatus);
		o.setDifStatus(difStatus);
		o.setMonthStatus(monthStatus);
		o.setTotal(datas.size());

		// 計算 up45After14Days
		Integer up45After14Days = 0;
		for (Dashboard d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() >= 45)
				up45After14Days++;
		}
		o.setUp45After14Days(up45After14Days);

		// 計算 down60After14Days
		Integer down45After14Days = 0;
		for (Dashboard d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() <= -45)
				down45After14Days++;
		}
		o.setDown45After14Days(down45After14Days);

		// 計算 up60After14Days
		Integer up60After14Days = 0;
		for (Dashboard d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() >= 60)
				up60After14Days++;
		}
		o.setUp60After14Days(up60After14Days);

		// 計算 down60After14Days
		Integer down60After14Days = 0;
		for (Dashboard d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() <= -60)
				down60After14Days++;
		}
		o.setDown60After14Days(down60After14Days);
		
		// 計算 sumUpAfter14Days 總上漲點數
		// 計算 sumUpPcAfter14Days 總上漲％
		// 計算 sumDownAfter14Days 總下跌點數
		// 計算 sumDownPcAfter14Days 總下跌％
		Double sumUpAfter14Days = 0.0;
		Double sumUpPcAfter14Days = 0.0;
		Double sumDownAfter14Days = 0.0;
		Double sumDownPcAfter14Days = 0.0;
		for (Dashboard d : datas) {
			if(d.getRange() > 0) {
				sumUpAfter14Days += d.getRange();
				sumUpPcAfter14Days += d.getRange() / (d.getClose() - d.getRange());
			}
			if(d.getRange() < 0) {
				sumDownAfter14Days += d.getRange();
				sumDownPcAfter14Days += d.getRange() / (d.getClose() - d.getRange());
			}
		}
		o.setSumUpAfter14Days(sumUpAfter14Days);
		o.setSumUpPcAfter14Days(sumUpPcAfter14Days);
		o.setSumDownAfter14Days(sumDownAfter14Days);
		o.setSumDownPcAfter14Days(sumDownPcAfter14Days);

		return o;

	}

	public static class Statistics001 {
		String statistics001Id;
		String difStatus;
		String monthStatus;

		Integer up45After14Days;
		Integer down45After14Days;

		Integer up60After14Days;
		Integer down60After14Days;
		
		Double sumUpAfter14Days;
		Double sumUpPcAfter14Days;
		Double sumDownAfter14Days;
		Double sumDownPcAfter14Days;
		
		Integer total;

		
		

		public Double getSumUpAfter14Days() {
			return sumUpAfter14Days;
		}

		public void setSumUpAfter14Days(Double sumUpAfter14Days) {
			this.sumUpAfter14Days = sumUpAfter14Days;
		}

		public Double getSumUpPcAfter14Days() {
			return sumUpPcAfter14Days;
		}

		public void setSumUpPcAfter14Days(Double sumUpPcAfter14Days) {
			this.sumUpPcAfter14Days = sumUpPcAfter14Days;
		}

		public Double getSumDownAfter14Days() {
			return sumDownAfter14Days;
		}

		public void setSumDownAfter14Days(Double sumDownAfter14Days) {
			this.sumDownAfter14Days = sumDownAfter14Days;
		}

		public Double getSumDownPcAfter14Days() {
			return sumDownPcAfter14Days;
		}

		public void setSumDownPcAfter14Days(Double sumDownPcAfter14Days) {
			this.sumDownPcAfter14Days = sumDownPcAfter14Days;
		}

		public Integer getUp45After14Days() {
			return up45After14Days;
		}

		public void setUp45After14Days(Integer up45After14Days) {
			this.up45After14Days = up45After14Days;
		}

		public Integer getDown45After14Days() {
			return down45After14Days;
		}

		public void setDown45After14Days(Integer down45After14Days) {
			this.down45After14Days = down45After14Days;
		}

		public String getStatistics001Id() {
			return statistics001Id;
		}

		public void setStatistics001Id(String statistics001Id) {
			this.statistics001Id = statistics001Id;
		}

		public String getDifStatus() {
			return difStatus;
		}

		public void setDifStatus(String difStatus) {
			this.difStatus = difStatus;
		}

		public String getMonthStatus() {
			return monthStatus;
		}

		public void setMonthStatus(String monthStatus) {
			this.monthStatus = monthStatus;
		}

		public Integer getUp60After14Days() {
			return up60After14Days;
		}

		public void setUp60After14Days(Integer up60After14Days) {
			this.up60After14Days = up60After14Days;
		}

		public Integer getDown60After14Days() {
			return down60After14Days;
		}

		public void setDown60After14Days(Integer down60After14Days) {
			this.down60After14Days = down60After14Days;
		}

		public Integer getTotal() {
			return total;
		}

		public void setTotal(Integer total) {
			this.total = total;
		}

	}

}
