package com.aistock.analyst.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.util.RestResponse;


public class BaseController {

	
	
	
	// 建立 Pageable
	protected Pageable getPageable(HttpServletRequest request) {
		int limit = Integer.parseInt(request.getParameter("limit"));
		int page = Integer.parseInt(request.getParameter("page"));

		Sort sort = new Sort(Direction.ASC, "_id");

		Pageable pageable = new PageRequest(page - 1, limit, sort);
		return pageable;
	}

	protected Pageable getPageable(HttpServletRequest request, Sort sort) {
		int limit = Integer.parseInt(request.getParameter("limit"));
		int page = Integer.parseInt(request.getParameter("page"));

		Pageable pageable = new PageRequest(page - 1, limit, sort);

		return pageable;
	}

}
