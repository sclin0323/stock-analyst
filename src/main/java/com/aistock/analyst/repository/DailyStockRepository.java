package com.aistock.analyst.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.DailyStock;


@Repository
public interface DailyStockRepository extends MongoRepository<DailyStock, String> {
	
	
	public List<DailyStock> findByDateAndMonthStatus(String date, String status);
	
	public List<DailyStock> findByDateAndDifStatus(String date, String status);
	
	
	public List<DailyStock> findByDateAndMonthStatusAndStockNumIn(String date, String status, List<String> stockNums);
	
	public List<DailyStock> findByDateAndDifStatusAndStockNumIn(String date, String status, List<String> stockNums);
	
	public List<DailyStock> findByDateAndStockNumIn(String date, List<String> stockNums);

	@Query(value="{ 'stockNum' : ?0 }", fields="{ 'date' : 1}")
	public List<DailyStock> findByStockNum(String stockNum);
}

