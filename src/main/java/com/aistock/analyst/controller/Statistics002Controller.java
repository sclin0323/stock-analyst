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
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.repository.FinanceRepository;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/statistics002")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class Statistics002Controller extends BaseController {
	Logger log = LoggerFactory.getLogger(Statistics002Controller.class);

	@Autowired(required = true)
	FinanceRepository financeRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String difStatus,
			String monthStatus) throws IOException {

		List<Statistics002> lists = new ArrayList<Statistics002>();

		lists.add(getStatistics002("DIF持續走多", "月上季上"));
		lists.add(getStatistics002("DIF持續走多", "月下季上"));
		lists.add(getStatistics002("DIF持續走多", "月下季下"));
		lists.add(getStatistics002("DIF持續走多", "月上季下"));

		lists.add(getStatistics002("DIF由多轉空", "月上季上"));
		lists.add(getStatistics002("DIF由多轉空", "月下季上"));
		lists.add(getStatistics002("DIF由多轉空", "月下季下"));
		lists.add(getStatistics002("DIF由多轉空", "月上季下"));

		lists.add(getStatistics002("DIF持續走空", "月上季上"));
		lists.add(getStatistics002("DIF持續走空", "月下季上"));
		lists.add(getStatistics002("DIF持續走空", "月下季下"));
		lists.add(getStatistics002("DIF持續走空", "月上季下"));

		lists.add(getStatistics002("DIF由空轉多", "月上季上"));
		lists.add(getStatistics002("DIF由空轉多", "月下季上"));
		lists.add(getStatistics002("DIF由空轉多", "月下季下"));
		lists.add(getStatistics002("DIF由空轉多", "月上季下"));

//		lists.add(getStatistics002("*********", "*******"));
//		lists.add(getStatistics002("DIF持續走多", "月"));
//		lists.add(getStatistics002("DIF由多轉空", "月"));
//		lists.add(getStatistics002("DIF持續走空", "月"));
//		lists.add(getStatistics002("DIF由空轉多", "月"));
//
//		lists.add(getStatistics002("*********", "*******"));
//		lists.add(getStatistics002("DIF持續走多", "月上"));
//		lists.add(getStatistics002("DIF持續走多", "月下"));
//
//		lists.add(getStatistics002("DIF由多轉空", "月上"));
//		lists.add(getStatistics002("DIF由多轉空", "月下"));
//
//		lists.add(getStatistics002("DIF持續走空", "月上"));
//		lists.add(getStatistics002("DIF持續走空", "月下"));
//
//		lists.add(getStatistics002("DIF由空轉多", "月上"));
//		lists.add(getStatistics002("DIF由空轉多", "月下"));

		return RestResponse.success(lists, lists.size());
	}

	private Statistics002 getStatistics002(String difStatus, String monthStatus) {

		List<Finance> datas = financeRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus);

		Statistics002 o = new Statistics002();
		o.setStatistics002Id(difStatus + monthStatus);
		o.setDifStatus(difStatus);
		o.setMonthStatus(monthStatus);
		o.setTotal(datas.size());

		// 計算 up12After14Days
		Integer up12After14Days = 0;
		for (Finance d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() >= 12)
				up12After14Days++;
		}
		o.setUp12After14Days(up12After14Days);

		// 計算 down12After14Days
		Integer down12After14Days = 0;
		for (Finance d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() <= -12)
				down12After14Days++;
		}
		o.setDown12After14Days(down12After14Days);

		// 計算 up17After14Days
		Integer up17After14Days = 0;
		for (Finance d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() >= 17)
				up17After14Days++;
		}
		o.setUp17After14Days(up17After14Days);

		// 計算 down60After14Days
		Integer down17After14Days = 0;
		for (Finance d : datas) {
			if (d.getAfter14Days() != null && d.getAfter14Days() <= -17)
				down17After14Days++;
		}
		o.setDown17After14Days(down17After14Days);

		return o;

	}

	public static class Statistics002 {
		String statistics002Id;
		String difStatus;
		String monthStatus;

		Integer up12After14Days;
		Integer down12After14Days;

		Integer up17After14Days;
		Integer down17After14Days;
		Integer total;

		

		public String getStatistics002Id() {
			return statistics002Id;
		}

		public void setStatistics002Id(String statistics002Id) {
			this.statistics002Id = statistics002Id;
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

		

		public Integer getUp12After14Days() {
			return up12After14Days;
		}

		public void setUp12After14Days(Integer up12After14Days) {
			this.up12After14Days = up12After14Days;
		}

		public Integer getDown12After14Days() {
			return down12After14Days;
		}

		public void setDown12After14Days(Integer down12After14Days) {
			this.down12After14Days = down12After14Days;
		}

		public Integer getUp17After14Days() {
			return up17After14Days;
		}

		public void setUp17After14Days(Integer up17After14Days) {
			this.up17After14Days = up17After14Days;
		}

		public Integer getDown17After14Days() {
			return down17After14Days;
		}

		public void setDown17After14Days(Integer down17After14Days) {
			this.down17After14Days = down17After14Days;
		}

		public Integer getTotal() {
			return total;
		}

		public void setTotal(Integer total) {
			this.total = total;
		}

	}

}
