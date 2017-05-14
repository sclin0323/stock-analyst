package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.OtcStock;

public interface OtcStockService {

	Page<OtcStock> findAll(Pageable pageable);

	OtcStock create(OtcStock obj);

	OtcStock update(OtcStock obj);

	OtcStock delete(OtcStock obj);

}
