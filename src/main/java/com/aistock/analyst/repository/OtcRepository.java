package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.Otc;


@Repository
public interface OtcRepository extends MongoRepository<Otc, String> {
	
	public List<Otc> findByOtcIdBetweenOrderByOtcIdDesc(String start, String end);
	
	public Page<Otc> findByDifStatus(String difStatus, Pageable pageable);

	public Page<Otc> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
	
	public List<Otc> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus);
}

