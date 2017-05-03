package com.aistock.analyst.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aistock.analyst.entity.Taiwan50Stock;

public interface Taiwan50StockService {

	Page<Taiwan50Stock> findAll(Pageable pageable);

	Taiwan50Stock create(Taiwan50Stock obj);

	Taiwan50Stock update(Taiwan50Stock obj);

	Taiwan50Stock delete(Taiwan50Stock obj);

	List<String> getStockList();

}
