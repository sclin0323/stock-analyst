package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.DailyAveIndex;
import com.aistock.analyst.entity.DailyStock;


@Repository
public interface DailyAveIndexRepository extends MongoRepository<DailyAveIndex, String> {
	
	public List<DailyAveIndex> findByName(String name);
}

