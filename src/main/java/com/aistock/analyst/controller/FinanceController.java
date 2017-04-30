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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.FinanceStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.FinanceStockRepository;
import com.aistock.analyst.service.FinanceService;
import com.aistock.analyst.status.StockStatus;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/finance")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class FinanceController extends BaseController {

	Logger log = LoggerFactory.getLogger(FinanceController.class);

	@Autowired(required = true)
	FinanceService financeService;
	
	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;
	
	@Autowired(required = true)
	FinanceStockRepository financeStockRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String difStatus, String monthStatus) throws IOException {
		
		if(difStatus != null && monthStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "financeId"));
			Page<Finance> datas = financeService.findByDifStatusAndMonthStatus(difStatus, monthStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
			
		} 
		
		if(difStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "financeId"));
			Page<Finance> datas = financeService.findByDifStatus(difStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
		}

		Pageable pageable = getPageable(request, new Sort(Direction.DESC, "financeId"));
		Page<Finance> datas = financeService.findAll(pageable);

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}
	
	@RequestMapping(value = "/readFinanceStock", method = RequestMethod.GET)
	public RestResponse readFinanceStock(HttpServletRequest request, HttpServletResponse response, String financeId) throws IOException {
		
		// 取得追蹤金融LIST
		List<FinanceStock> lists = financeStockRepository.findAll();
		List<String> fs = new ArrayList<String>();
		for(FinanceStock o : lists) {
			fs.add(o.getFinanceStockId());
		}
		
		List<DailyStock> datas = dailyStockRepository.findByDateAndStockNumIn(financeId, fs);
		
		datas.forEach((DailyStock o) -> {
			o.setStockId(o.getDate()+o.getStockNum());
		});

		return RestResponse.success(datas, datas.size());

	}
	
	

}
