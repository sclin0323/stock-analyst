package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.DailyStock;


@Repository
public interface DailyStockRepository extends MongoRepository<DailyStock, String> {
	
	
	public List<DailyStock> findByDateAndMonthStatus(String date, String status);
	
	public List<DailyStock> findByDateAndDifStatus(String date, String status);
	
	@Query(value = "{}", fields = "{'jarFileBytes': 0}")
	public List<DailyStock> findField();
	//List<DailyStock> findByDateContaining(String date);
}

