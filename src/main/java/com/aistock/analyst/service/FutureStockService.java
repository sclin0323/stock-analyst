package com.aistock.analyst.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.FutureStock;

public interface FutureStockService {

	Page<FutureStock> findAll(Pageable pageable);

	FutureStock create(FutureStock futureStock);

	FutureStock update(FutureStock futureStock);

	FutureStock delete(FutureStock futureStock);

}
