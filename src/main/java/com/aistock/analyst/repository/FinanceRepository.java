package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.Finance;


@Repository
public interface FinanceRepository extends MongoRepository<Finance, String> {
	
	public List<Finance> findByFinanceIdBetweenOrderByFinanceIdDesc(String start, String end);
	
	public Page<Finance> findByDifStatus(String difStatus, Pageable pageable);

	public Page<Finance> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
	
	public List<Finance> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus);
}

