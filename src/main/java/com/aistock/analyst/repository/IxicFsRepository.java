package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.entity.DjiFs;
import com.aistock.analyst.entity.Finance;
import com.aistock.analyst.entity.IxicFs;
import com.aistock.analyst.entity.Otc;


@Repository
public interface IxicFsRepository extends MongoRepository<IxicFs, String> {
	
	public List<IxicFs> findByIxicFsIdBetweenOrderByIxicFsIdDesc(String start, String end);
	
	public Page<IxicFs> findByDifStatus(String difStatus, Pageable pageable);

	public Page<IxicFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus, Pageable pageable);
	
	public List<IxicFs> findByDifStatusAndMonthStatusContaining(String difStatus, String monthStatus);
}

