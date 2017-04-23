package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.DifStatus;


@Repository
public interface DifStatusRepository extends MongoRepository<DifStatus, String> {
	
	
	
}

