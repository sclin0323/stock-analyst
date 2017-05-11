package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.OtcStock;


@Repository
public interface OtcStockRepository extends MongoRepository<OtcStock, String> {
	
	
}

