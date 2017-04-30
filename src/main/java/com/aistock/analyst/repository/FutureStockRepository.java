package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.FutureStock;


@Repository
public interface FutureStockRepository extends MongoRepository<FutureStock, String> {

	//List<FutureStock> findByEnabled(boolean enabled);

	List<FutureStock> findByEnabledOrderByWeightDesc(boolean enabled);
	
	
}

