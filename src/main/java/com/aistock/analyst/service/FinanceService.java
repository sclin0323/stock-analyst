package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.Finance;

public interface FinanceService {

	Page<Finance> findAll(Pageable pageable);

	Page<Finance> findByDifStatus(String difStatus, Pageable pageable);

	Page<Finance> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable);

}
