package com.aistock.analyst.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@EnableMongoRepositories("com.fubon.test.repo")
public class MongoConfigProd {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		
//		MongoCredential journaldevAuth = MongoCredential.createCredential("mongoadmin", "eap=prod", "1qaz@WSX".toCharArray());
//	    List<MongoCredential> auths = new ArrayList<MongoCredential>();
//	    auths.add(journaldevAuth);
//		MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.191.137", 27017), auths);
		
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://test1:test1@10.240.3.191/eap-prod"));


		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "eap-prod");
		
		
		return mongoTemplate;
	}
}
