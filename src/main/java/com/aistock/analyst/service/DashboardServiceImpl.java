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
		
		});

		return page;
	}

	@Override
	public Page<Dashboard> findByDifStatus(String difStatus, Pageable pageable) {

		Page<Dashboard> page = dashboardRepository.findByDifStatus(difStatus, pageable);

		page.getContent().forEach((Dashboard o) -> {

		});

		return page;
	}

	@Override
	public Page<Dashboard> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable) {

		Page<Dashboard> page = dashboardRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus,
				pageable);

		page.getContent().forEach((Dashboard o) -> {
	
		});

		return page;
	}

}
