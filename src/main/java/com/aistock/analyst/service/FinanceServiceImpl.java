package com.aistock.analyst.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.repository.FinanceRepository;

@Service
public class FinanceServiceImpl implements FinanceService {

	Logger log = LoggerFactory.getLogger(FinanceServiceImpl.class);

	@Autowired
	FinanceRepository financeRepository;

	@Override
	public Page<Finance> findAll(Pageable pageable) {

		Page<Finance> page = financeRepository.findAll(pageable);

		page.getContent().forEach((Finance o) -> {

		});

		return page;
	}

	@Override
	public Page<Finance> findByDifStatus(String difStatus, Pageable pageable) {

		Page<Finance> page = financeRepository.findByDifStatus(difStatus, pageable);

		page.getContent().forEach((Finance o) -> {

		});

		return page;
	}

	@Override
	public Page<Finance> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable) {

		Page<Finance> page = financeRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus,
				pageable);

		page.getContent().forEach((Finance o) -> {

		});

		return page;
	}

}
