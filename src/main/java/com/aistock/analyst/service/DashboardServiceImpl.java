package com.aistock.analyst.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.controller.DashboardController;
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DashboardRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

	Logger log = LoggerFactory.getLogger(DashboardServiceImpl.class);

	@Autowired
	DashboardRepository dashboardRepository;

	@Override
	public Page<Dashboard> findAll(Pageable pageable) {

		Page<Dashboard> page = dashboardRepository.findAll(pageable);

		page.getContent().forEach((Dashboard o) -> {
			// 後 2 3 14日實際漲跌點
			setValues(o);
		});

		return page;
	}

	@Override
	public Page<Dashboard> findByDifStatus(String difStatus, Pageable pageable) {

		Page<Dashboard> page = dashboardRepository.findByDifStatus(difStatus, pageable);

		page.getContent().forEach((Dashboard o) -> {
			// 後 2 3 14日實際漲跌點
			setValues(o);
		});

		return page;
	}

	@Override
	public Page<Dashboard> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable) {
		
		Page<Dashboard> page = dashboardRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus, pageable);

		page.getContent().forEach((Dashboard o) -> {
			 // 後 2 3 14日實際漲跌點			
			setValues(o);
		});

		return page;
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
				Double value1 = datas.get(0).getClose() - o.getClose();
				o.setValue1(value1.intValue());
				
				// 2天
				Double value2 = datas.get(datas.size()-2).getClose() - o.getClose();
				o.setValue2(value2.intValue());
				
				// 3天
				Double value3 = datas.get(datas.size()-3).getClose() - o.getClose();
				o.setValue3(value3.intValue());
				
				// 1天
				Double value4 = datas.get(datas.size()-1).getClose() - o.getClose();
				o.setValue4(value4.intValue());
				
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
