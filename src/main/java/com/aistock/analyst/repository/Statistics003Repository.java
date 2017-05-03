package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Statistics003;


@Repository
public interface Statistics003Repository extends MongoRepository<Statistics003, String> {


	
	
}

