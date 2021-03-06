package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.Otc;

public interface OtcService {

	Page<Otc> findAll(Pageable pageable);

	Page<Otc> findByDifStatus(String difStatus, Pageable pageable);

	Page<Otc> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable);

}
