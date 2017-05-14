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
import com.aistock.analyst.entity.Otc;
import com.aistock.analyst.entity.OtcStock;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.OtcStockRepository;
import com.aistock.analyst.service.OtcService;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/otc")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class OtcController extends BaseController {

	Logger log = LoggerFactory.getLogger(OtcController.class);

	@Autowired(required = true)
	OtcService otcService;
	
	@Autowired(required = true)
	DailyStockRepository dailyStockRepository;
	
	@Autowired(required = true)
	OtcStockRepository otcStockRepository;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response, String difStatus, String monthStatus) throws IOException {
		
		if(difStatus != null && monthStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "otcId"));
			Page<Otc> datas = otcService.findByDifStatusAndMonthStatus(difStatus, monthStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
			
		} 
		
		if(difStatus != null) {
			
			Pageable pageable = getPageable(request, new Sort(Direction.DESC, "otcId"));
			Page<Otc> datas = otcService.findByDifStatus(difStatus, pageable);
			
			return RestResponse.success(datas.getContent(), datas.getTotalElements());
		}

		Pageable pageable = getPageable(request, new Sort(Direction.DESC, "otcId"));
		Page<Otc> datas = otcService.findAll(pageable);

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}
	
	@RequestMapping(value = "/readOtcStock", method = RequestMethod.GET)
	public RestResponse readFinanceStock(HttpServletRequest request, HttpServletResponse response, String otcId) throws IOException {
		
		// 取得追蹤金融LIST
		List<OtcStock> lists = otcStockRepository.findAll();
		List<String> fs = new ArrayList<String>();
		for(OtcStock o : lists) {
			if(o.getEnabled()) {
				fs.add(o.getOtcStockId());
			}
		}
		
		List<DailyStock> datas = dailyStockRepository.findByDateAndStockNumIn(otcId, fs);
		
		datas.forEach((DailyStock o) -> {
			//o.setStockId(o.getDate()+o.getStockNum());
		});

		return RestResponse.success(datas, datas.size());

	}
	
	

}
