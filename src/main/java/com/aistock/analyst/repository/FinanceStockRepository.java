package com.aistock.analyst.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.FinanceStock;
import com.aistock.analyst.entity.FutureStock;


@Repository
public interface FinanceStockRepository extends MongoRepository<FinanceStock, String> {
	
	
}

