package com.aistock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfigProd;
import com.fubon.test.repo.PcmlRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfigProd.class })
public class TestEapProd {

	Logger log = LoggerFactory.getLogger(TestEapProd.class);
	
	//@Autowired
	//MongoTemplate mongoTemplate;
	
	@Autowired
	PcmlRepository pcmlRepository;

	@Test
	public void test001() throws Exception{
		
		log.info("Size: "+pcmlRepository.findAll().size());
	}
	


}
