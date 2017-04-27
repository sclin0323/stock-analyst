package com.aistock.analyst.imports;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aistock.analyst.config.MongoConfig;
import com.aistock.analyst.entity.DailyAveIndex;
import com.aistock.analyst.repository.DailyAveIndexRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class ImportDailyAveIndex {

	Logger log = LoggerFactory.getLogger(ImportDailyAveIndex.class);

	@Autowired
	DailyAveIndexRepository dailyAveIndexRepository;

	@Test
	public void importDailyAveIndex() throws Exception {

		ArrayList<File> files = new ArrayList<File>();

		files.add(new File("C:\\SysJust\\XQLite\\XS\\Print\\日常追蹤(台、金融、美股)_TSE.TW.log"));
		files.add(new File("C:\\SysJust\\XQLite\\XS\\Print\\日常追蹤(台、金融、美股)_TSE28.TW.log"));

		for (final File file : files) {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Big5"));

			log.info(file.getName());

			String line;
			while ((line = br.readLine()) != null) {

				log.info(line);

				String[] strArray = line.replaceAll("\\s+", "").split(":");

				String date = strArray[0].split("\\.")[0];
				String name = strArray[1];
				String monthStatus = strArray[2];
				String difStatus = strArray[3];
				Double range = Double.parseDouble(strArray[4]);
				Double close = Double.parseDouble(strArray[5]);
				Integer volume = (int)(((long)(Float.parseFloat(strArray[6]))) / 100000000);

				DailyAveIndex o = new DailyAveIndex();

				o.setDailyAveIndexId(new ObjectId());
				o.setDate(date);
				o.setName(name);
				o.setMonthStatus(monthStatus);
				o.setDifStatus(difStatus);
				o.setRange(range);
				o.setClose(close);
				o.setVolume(volume);
				
				// 檢查是否已經存在
				if(dailyAveIndexRepository.findByDateAndName(date, name) != null){
					continue;
				}
				
				dailyAveIndexRepository.save(o);

			}
		}

	}

}
