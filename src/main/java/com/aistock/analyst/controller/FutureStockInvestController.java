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
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.entity.FutureStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DashboardRepository;
import com.aistock.analyst.repository.FutureStockRepository;
import com.aistock.analyst.status.StockStatus;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/futureStockInvest")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class FutureStockInvestController extends BaseController{

	Logger log = LoggerFactory.getLogger(FinanceController.class);
	
	@Autowired(required = true)
	DashboardRepository dashboardRepository;

	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;
	
	@Autowired(required = true)
	FutureStockRepository futureStockRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, Boolean enabled) throws IOException {
		
		if(enabled != null) {
			List<FutureStock> lists = futureStockRepository.findByEnabledOrderByWeightDesc(enabled);
			return RestResponse.success(lists, lists.size());
		}
	
		List<FutureStock> lists = futureStockRepository.findByEnabledOrderByWeightDesc(true);
		return RestResponse.success(lists, lists.size());
	}
	
	@RequestMapping(value = "/readFutureStockHistory", method = RequestMethod.GET)
	public RestResponse readFutureStockHistory(HttpServletRequest request, HttpServletResponse response, String stockNum) throws IOException {
		
		List<DailyStock> datas = dailyStockRepository.findByStockNumOrderByDateDesc(stockNum);

		datas.forEach((DailyStock o) -> {
			o.setStockId(o.getDate() + o.getStockNum());
		});

		return RestResponse.success(datas, datas.size());
	}
	
	

}
