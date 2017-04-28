package com.aistock.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.DailyStock;
import com.aistock.analyst.imports.ImportDailyStock;
import com.aistock.analyst.repository.DailyStockRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class FixStockName {

	Logger log = LoggerFactory.getLogger(ImportDailyStock.class);

	@Autowired
	DailyStockRepository dailyStockRepository;

	@Test
	public void importDailyStock() throws Exception {

		File folder = new File("C:\\SysJust\\XQLite\\XS\\Print");

		for (final File file : folder.listFiles()) {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));

			if (!file.getName().contains("個股日線追蹤")) {
				continue;
			}
			
			String line = br.readLine();
			
			String[] strArray = line.replaceAll("\\s+", "").split(":");
			String stockNum = (file.getName()).split("\\.")[0].split("_")[1];
			String stockName = strArray[1];
			log.info(strArray[1]+"  "+stockNum);
			
			List<DailyStock> datas = dailyStockRepository.findByStockNum(stockNum);
			
			for(DailyStock o : datas) {
				o.setStockName(stockName);
				dailyStockRepository.save(o);
			}
			
			
			continue;

		}

	}

}
