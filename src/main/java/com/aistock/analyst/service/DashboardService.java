package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.Dashboard;

public interface DashboardService {

	Page<Dashboard> findAll(Pageable pageable);

	Page<Dashboard> findByDifStatus(String difStatus, Pageable pageable);

	Page<Dashboard> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable);

}
