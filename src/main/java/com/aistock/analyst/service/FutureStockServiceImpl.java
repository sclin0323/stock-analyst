package com.aistock.analyst.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.FutureStock;
import com.aistock.analyst.repository.FutureStockRepository;

@Service
public class FutureStockServiceImpl extends BaseServiceImpl implements FutureStockService {

	Logger log = LoggerFactory.getLogger(FutureStockServiceImpl.class);

	@Autowired
	FutureStockRepository futureStockRepository;

	@Override
	public Page<FutureStock> findAll(Pageable pageable) {

		Page<FutureStock> page = futureStockRepository.findAll(pageable);

		page.getContent().forEach((FutureStock o) -> {

		});

		return page;
	}

	@Override
	public FutureStock create(FutureStock futureStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FutureStock update(FutureStock obj) {

		FutureStock stored = futureStockRepository.findOne(obj.getFutureStockId());
		if(stored == null) {
			throw new IllegalArgumentException("資料不存在，無法更新");
		}
		
		//stored.setStockName(futureStock.getStockName());
		stored.setWeight(obj.getWeight());
		stored.setEnabled(obj.getEnabled());
		stored.setNote(obj.getNote());
		
		futureStockRepository.save(stored);
		
		return stored;
	}

	@Override
	public FutureStock delete(FutureStock futureStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
