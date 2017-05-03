package com.aistock.analyst.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.FutureStock;
import com.aistock.analyst.service.FutureStockService;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/futureStock")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class FutureStockController extends BaseController{

	Logger log = LoggerFactory.getLogger(FinanceController.class);
	
	@Autowired(required = true)
	FutureStockService futureStockService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		Pageable pageable = getPageable(request);
		Page<FutureStock> datas = futureStockService.findAll(pageable);

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public RestResponse create(@RequestBody FutureStock obj){


		FutureStock o = futureStockService.create(obj);
		return RestResponse.success(o);
		
	}

	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public RestResponse update(@RequestBody FutureStock obj){

		FutureStock o = futureStockService.update(obj);
		return RestResponse.success(o);
	}

	@RequestMapping(value="/destroy", method = RequestMethod.DELETE)
	public RestResponse destroy(@RequestBody FutureStock obj){

		FutureStock o = futureStockService.delete(obj);

		return RestResponse.success(o);
	}
	

}
