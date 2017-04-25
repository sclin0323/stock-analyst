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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.service.DashboardService;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/dashboard")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class DashboardController extends BaseController {

	Logger log = LoggerFactory.getLogger(DashboardController.class);

	@Autowired(required = true)
	DashboardService dashboardService;

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

}
