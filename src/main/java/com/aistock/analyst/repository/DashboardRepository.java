package com.aistock.analyst.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aistock.analyst.entity.Dashboard;


@Repository
public interface DashboardRepository extends MongoRepository<Dashboard, String> {
	

}

