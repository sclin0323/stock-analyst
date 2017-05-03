package com.aistock.analyst.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Taiwan50Stock;


@Repository
public interface Taiwan50StockRepository extends MongoRepository<Taiwan50Stock, String> {

	Page<Taiwan50Stock> findAllOrderByWeight(Pageable pageable);
	
	
}

