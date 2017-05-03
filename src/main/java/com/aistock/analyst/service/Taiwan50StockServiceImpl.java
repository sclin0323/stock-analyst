package com.aistock.analyst.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.Taiwan50Stock;
import com.aistock.analyst.repository.Taiwan50StockRepository;

@Service
public class Taiwan50StockServiceImpl extends BaseServiceImpl implements Taiwan50StockService {

	Logger log = LoggerFactory.getLogger(Taiwan50StockServiceImpl.class);

	@Autowired
	Taiwan50StockRepository taiwan50StockRepository;

	@Override
	public Page<Taiwan50Stock> findAll(Pageable pageable) {

		
		Page<Taiwan50Stock> page = taiwan50StockRepository.findAll(pageable);

		page.getContent().forEach((Taiwan50Stock o) -> {

		});

		return page;
	}

	@Override
	public Taiwan50Stock create(Taiwan50Stock futureStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Taiwan50Stock update(Taiwan50Stock obj) {

		Taiwan50Stock stored = taiwan50StockRepository.findOne(obj.getTaiwan50StockId());
		if(stored == null) {
			throw new IllegalArgumentException("資料不存在，無法更新");
		}
		
		//stored.setStockName(futureStock.getStockName());
		stored.setWeight(obj.getWeight());
		stored.setEnabled(obj.getEnabled());
		stored.setNote(obj.getNote());
		
		taiwan50StockRepository.save(stored);
		
		return stored;
	}

	@Override
	public Taiwan50Stock delete(Taiwan50Stock futureStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getStockList() {
		Sort sort = new Sort(Direction.DESC, "weight");
		List<Taiwan50Stock> lists = taiwan50StockRepository.findAll(sort);
		
		List<String> datas = new ArrayList<String>();
		for(Taiwan50Stock o:lists) {
			datas.add(o.getTaiwan50StockId());
		}
		
		return datas;
	}

}
