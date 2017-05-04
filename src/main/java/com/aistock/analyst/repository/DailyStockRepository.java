package com.aistock.analyst.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<DailyStock> findByDate(String date, Pageable pageable);

	public Page<DailyStock> findByDateAndDifStatus(String date, String difStatus, Pageable pageable);

	public Page<DailyStock> findByDateInAndDifStatus(List<String> dates, String difStatus, Pageable pageable);

	public Page<DailyStock> findByDateInAndDifStatusAndMonthStatusContaining(List<String> dates, String difStatus,
			String monthStatus, Pageable pageable);
	
	public DailyStock findByDateAndStockNum(String date, String stockNum);

	public List<DailyStock> findByStockNum(String stockNum);

	public List<DailyStock> findByStockNumOrderByDateDesc(String stockNum);

	public Page<DailyStock> findByStockNumOrderByDateDesc(String stockNum, Pageable pageable);



	public List<DailyStock> findByForeignInvestIn30DaysStatus(String status);

	public List<DailyStock> findByStockNumAndDateBetweenOrderByDateDesc(String stockNum, String startDay,
			String endDay);

	public List<DailyStock> findByDifStatusAndMonthStatusContainingAndForeignInvestIn30DaysStatusAndVolumeInvestIn30DaysGreaterThan(
			String difStatus, String monthStatus, String investStatus, long volume);

	public List<DailyStock> findByDifStatusAndMonthStatusContainingAndForeignInvestIn30DaysStatusAndStockNumIn(
			String difStatus, String monthStatus, String investStatus, ArrayList<String> weightList);

	public Page<DailyStock> findByDifStatusAndMonthStatusContainingAndForeignInvestIn30DaysStatusAndVolumeInvestIn30DaysGreaterThanOrderByVolumeInvestIn30Days(
			String difStatus, String monthStatus, String investStatus, long l, Pageable pageable);



}
