package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.MonthStatus;


@Repository
public interface MonthStatusRepository extends MongoRepository<MonthStatus, String> {
	
}

