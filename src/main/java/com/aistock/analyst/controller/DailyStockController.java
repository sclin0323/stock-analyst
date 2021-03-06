package com.aistock.analyst.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/dailyStock")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class DailyStockController extends BaseController {

	Logger log = LoggerFactory.getLogger(DailyStockController.class);

	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String startDay, String difStatus, String monthStatus) throws IOException {
		
		
		List<String> dates = new ArrayList<String>();
		dates.add("20170512");
		dates.add("20170511");
		//dates.add("20170510");
		//dates.add("20170509");
		//dates.add("20170508");
		
		
		Pageable pageable = getPageable(request);
		
		if(difStatus != null && monthStatus != null) {
			Page<DailyStock> datas = dailyStockRepository.findByDateInAndDifStatusAndMonthStatusContaining(dates, difStatus, monthStatus, pageable);
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
		}
		
		if(difStatus != null) {
			Page<DailyStock> datas = dailyStockRepository.findByDateInAndDifStatus(dates, difStatus, pageable);
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
		}
		
		
		

		Page<DailyStock> datas = dailyStockRepository.findByDate("20170512", pageable);
		
		

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}

}
