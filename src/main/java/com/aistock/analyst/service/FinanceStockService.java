package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.FinanceStock;

public interface FinanceStockService {

	Page<FinanceStock> findAll(Pageable pageable);

	FinanceStock create(FinanceStock obj);

	FinanceStock update(FinanceStock obj);

	FinanceStock delete(FinanceStock obj);

}
