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
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.Dashboard;
import com.aistock.analyst.repository.DashboardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class DashboardInfo {

	Logger log = LoggerFactory.getLogger(DashboardInfo.class);

	@Autowired
	DashboardRepository dashboardRepository;

	@Test
	public void test001() throws Exception {

		List<Dashboard> datas = dashboardRepository.findAll(new Sort(Sort.Direction.DESC, "dashboardId"));

		ObjectMapper mapper = new ObjectMapper();

		// Object to JSON in file
		mapper.writeValue(new File("C:\\Users\\a8303\\Desktop\\Dashboards.txt"), datas);

		// Object to JSON in String
		String jsonInString = mapper.writeValueAsString(datas);

		log.info(jsonInString);

	}

}
