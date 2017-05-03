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
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aistock.analyst.entity.Taiwan50Stock;
import com.aistock.analyst.service.Taiwan50StockService;
import com.aistock.analyst.util.RestResponse;

@RestController
@RequestMapping(value = "/web/taiwan50Stock")
@PropertySource("classpath:config-${spring.profiles.active:local}.properties")
public class Taiwan50StockController extends BaseController{

	Logger log = LoggerFactory.getLogger(FinanceController.class);
	
	@Autowired(required = true)
	Taiwan50StockService taiwan50StockService;

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public RestResponse read(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		Pageable pageable = getPageable(request,  new Sort(Direction.DESC, "weight"));
		Page<Taiwan50Stock> datas = taiwan50StockService.findAll(pageable);

		return RestResponse.success(datas.getContent(), datas.getTotalElements());

	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public RestResponse create(@RequestBody Taiwan50Stock obj){


		Taiwan50Stock o = taiwan50StockService.create(obj);
		return RestResponse.success(o);
		
	}

	@RequestMapping(value="/update", method = RequestMethod.PUT)
	public RestResponse update(@RequestBody Taiwan50Stock obj){

		Taiwan50Stock o = taiwan50StockService.update(obj);
		return RestResponse.success(o);
	}

	@RequestMapping(value="/destroy", method = RequestMethod.DELETE)
	public RestResponse destroy(@RequestBody Taiwan50Stock obj){

		Taiwan50Stock o = taiwan50StockService.delete(obj);

		return RestResponse.success(o);
	}
	

}
