package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;


@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {
	
	public List<Dashboard> findByDashboardIdBetweenOrderByDashboardIdDesc(String start, String end);
	
	public Page<Dashboard> findByDifStatus(String difStatus, Pageable pageable);

	public Page<Dashboard> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
}

