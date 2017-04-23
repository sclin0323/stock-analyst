package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Test;


@Repository
public interface TestRepository extends MongoRepository<Test, String> {
	
}

