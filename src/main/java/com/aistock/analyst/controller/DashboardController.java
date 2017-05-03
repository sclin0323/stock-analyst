package com.aistock.analyst.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.service.DashboardService;
import com.aistock.analyst.service.Taiwan50StockService;
import com.aistock.analyst.status.StockStatus;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/dashboard")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class DashboardController extends BaseController {

	Logger log = LoggerFactory.getLogger(DashboardController.class);

	@Autowired(required = true)
	DashboardService dashboardService;
	
	@Autowired(required = true)
	Taiwan50StockService taiwan50StockService;
	
	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String difStatus, String monthStatus) throws IOException {
		
		if(difStatus != null && monthStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "dashboardId"));
			Page<Dashboard> datas = dashboardService.findByDifStatusAndMonthStatus(difStatus, monthStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
			
		} 
		
		if(difStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "dashboardId"));
			Page<Dashboard> datas = dashboardService.findByDifStatus(difStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
		}

		Pageable pageable = getPageable(request, new Sort(Direction.DESC, "dashboardId"));
		Page<Dashboard> datas = dashboardService.findAll(pageable);

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}
	
	@RequestMapping(value = "/readDashboardStock", method = RequestMethod.GET)
	public RestResponse readDashboardStock(HttpServletRequest request, HttpServletResponse response, String dashboardId) throws IOException {
		
		List<String> stockList = taiwan50StockService.getStockList();
		
		List<DailyStock> datas = dailyStockRepository.findByDateAndStockNumIn(dashboardId, stockList);
		
		datas.forEach((DailyStock o) -> {
			o.setStockId(o.getDate()+o.getStockNum());
		});

		return RestResponse.success(datas, datas.size());

	}

}
