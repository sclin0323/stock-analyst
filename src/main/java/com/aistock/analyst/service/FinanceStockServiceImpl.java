package com.aistock.analyst.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.FinanceStock;
import com.aistock.analyst.entity.FutureStock;
import com.aistock.analyst.repository.FinanceStockRepository;

@Service
public class FinanceStockServiceImpl extends BaseServiceImpl implements FinanceStockService {

	Logger log = LoggerFactory.getLogger(FinanceStockServiceImpl.class);

	@Autowired
	FinanceStockRepository financeStockRepository;

	@Override
	public Page<FinanceStock> findAll(Pageable pageable) {

		Page<FinanceStock> page = financeStockRepository.findAll(pageable);

		page.getContent().forEach((FinanceStock o) -> {

		});

		return page;
	}

	@Override
	public FinanceStock create(FinanceStock obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinanceStock update(FinanceStock obj) {

		FinanceStock stored = financeStockRepository.findOne(obj.getFinanceStockId());
		if(stored == null) {
			throw new IllegalArgumentException("資料不存在，無法更新");
		}
		
		stored.setWeight(obj.getWeight());
		stored.setEnabled(obj.getEnabled());
		stored.setNote(obj.getNote());
		
		financeStockRepository.save(stored);
		
		return stored;
	}

	@Override
	public FinanceStock delete(FinanceStock obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
