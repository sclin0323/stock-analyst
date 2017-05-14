package com.aistock.analyst.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.Otc;
import com.aistock.analyst.repository.OtcRepository;

@Service
public class OtcServiceImpl implements OtcService {

	Logger log = LoggerFactory.getLogger(OtcServiceImpl.class);

	@Autowired
	OtcRepository otcRepository;

	@Override
	public Page<Otc> findAll(Pageable pageable) {

		Page<Otc> page = otcRepository.findAll(pageable);

		page.getContent().forEach((Otc o) -> {

		});

		return page;
	}

	@Override
	public Page<Otc> findByDifStatus(String difStatus, Pageable pageable) {

		Page<Otc> page = otcRepository.findByDifStatus(difStatus, pageable);

		page.getContent().forEach((Otc o) -> {

		});

		return page;
	}

	@Override
	public Page<Otc> findByDifStatusAndMonthStatus(String difStatus, String monthStatus, Pageable pageable) {

		Page<Otc> page = otcRepository.findByDifStatusAndMonthStatusContaining(difStatus, monthStatus,
				pageable);

		page.getContent().forEach((Otc o) -> {

		});

		return page;
	}

}
