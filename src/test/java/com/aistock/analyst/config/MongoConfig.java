package com.aistock.analyst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@EnableMongoRepositories("com.aistock.analyst.repository")
public class MongoConfig {

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		
		MongoClient mongoClient = new MongoClient("192.168.191.137"); 
		
		//mongoClient = new MongoClient(new ServerAddress(host,port),new MongoClientOptions.Builder()
        //        .socketKeepAlive(true) // 是否保持长链接
        //        .connectionsPerHost(200) // 最大连接数
        //        .minConnectionsPerHost(20)// 最小连接数
        //         .build());
		
		return new MongoTemplate(mongoClient, "stockdb");
	}
}
