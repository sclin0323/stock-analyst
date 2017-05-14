package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.DjiFs;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.Otc;


@Repository
public interface DjiFsRepository extends MongoRepository<DjiFs, String> {
	
	public List<DjiFs> findByDjiFsIdBetweenOrderByDjiFsIdDesc(String start, String end);
	
	public Page<DjiFs> findByDifStatus(String difStatus, Pageable pageable);

	public Page<DjiFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
	
	public List<DjiFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus);
}

