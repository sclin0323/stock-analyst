package com.aistock.analyst.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aistock.analyst.entity.OtcStock;
import com.aistock.analyst.repository.OtcStockRepository;

@Service
public class OtcStockServiceImpl extends BaseServiceImpl implements OtcStockService {

	Logger log = LoggerFactory.getLogger(OtcStockServiceImpl.class);

	@Autowired
	OtcStockRepository otcStockRepository;

	@Override
	public Page<OtcStock> findAll(Pageable pageable) {

		Page<OtcStock> page = otcStockRepository.findAll(pageable);

		page.getContent().forEach((OtcStock o) -> {

		});

		return page;
	}

	@Override
	public OtcStock create(OtcStock obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OtcStock update(OtcStock obj) {

		OtcStock stored = otcStockRepository.findOne(obj.getOtcStockId());
		if(stored == null) {
			throw new IllegalArgumentException("資料不存在，無法更新");
		}
		
		stored.setWeight(obj.getWeight());
		stored.setEnabled(obj.getEnabled());
		stored.setNote(obj.getNote());
		
		otcStockRepository.save(stored);
		
		return stored;
	}

	@Override
	public OtcStock delete(OtcStock obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
