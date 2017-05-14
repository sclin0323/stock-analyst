package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.DjiFs;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.GspcFs;
import com.aistock.analyst.entity.Otc;


@Repository
public interface GspcFsRepository extends MongoRepository<GspcFs, String> {
	
	public List<GspcFs> findByGspcFsIdBetweenOrderByGspcFsIdDesc(String start, String end);
	
	public Page<GspcFs> findByDifStatus(String difStatus, Pageable pageable);

	public Page<GspcFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
	
	public List<GspcFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus);
}

