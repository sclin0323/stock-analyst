package com.aistock.analyst.info;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.calcu.ImportStatus;
import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.DifStatus;
import com.aistock.analyst.entity.MonthStatus;
import com.aistock.analyst.repository.DifStatusRepository;
import com.aistock.analyst.repository.MonthStatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class InfoMonthStatus {

	Logger log = LoggerFactory.getLogger(ImportStatus.class);

	@Autowired
	MonthStatusRepository monthStatusRepository;
	
	@Autowired
	DifStatusRepository difStatusRepository;

	@Test
	public void test001() throws Exception {

		List<MonthStatus> datas = monthStatusRepository.findAll();

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in file
		mapper.writeValue(new File("C:\\Users\\a8303\\Desktop\\MonthStatus.txt"), datas);

		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(datas);

		log.info(jsonInString);

	}
	
	@Test
	public void test002() throws Exception {

		List<DifStatus> datas = difStatusRepository.findAll();

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in file
		mapper.writeValue(new File("C:\\Users\\a8303\\Desktop\\DifStatus.txt"), datas);

		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(datas);

		log.info(jsonInString);

	}

}
