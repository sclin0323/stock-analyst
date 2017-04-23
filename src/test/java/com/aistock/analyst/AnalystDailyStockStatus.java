package com.aistock.analyst;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.service.DailyStockService;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class AnalystDailyStockStatus {
	
	Logger log = LoggerFactory.getLogger(AnalystDailyStockStatus.class);
	
	@Autowired
	DailyStockService dailyStockService;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Test
	public void test001() throws Exception {
		
		int days = 100;
		
		
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		
		for(int i = 0; i < days; i++) {
			Date today = getDate(i);
			System.out.println(dt1.format(today));
			
		}
		
		
		
		
	}
	
	private Date getDate(int i) {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, i*-1);
	    return cal.getTime();
	}

	
	public void show(String date) throws Exception{
		
		List<DailyStock> dataA = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSA);
		List<DailyStock> dataB = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSB);
		List<DailyStock> dataC = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSC);
		List<DailyStock> dataD = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSD);
		List<DailyStock> dataE = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSE);
		
		List<DailyStock> dataF = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSF);
		List<DailyStock> dataG = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSG);
		List<DailyStock> dataH = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSH);
		List<DailyStock> dataI = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSI);
		List<DailyStock> dataJ = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSJ);
		
		List<DailyStock> dataK = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSK);
		List<DailyStock> dataL = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSL);
		List<DailyStock> dataM = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSM);
		List<DailyStock> dataN = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSN);
		List<DailyStock> dataO = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSO);
		
		List<DailyStock> dataP = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSP);
		List<DailyStock> dataQ = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSQ);
		List<DailyStock> dataR = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSR);
		List<DailyStock> dataS = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUSS);
		List<DailyStock> dataT = dailyStockRepository.findByDateAndStatus(date,StockStatus.STATUST);
		
		log.info(StockStatus.STATUSA+":"+dataA.size());
		log.info(StockStatus.STATUSB+":"+dataB.size());
		log.info(StockStatus.STATUSC+":"+dataC.size());
		log.info(StockStatus.STATUSD+":"+dataD.size());
		log.info(StockStatus.STATUSE+":"+dataE.size());
		
		log.info(StockStatus.STATUSF+":"+dataF.size());
		log.info(StockStatus.STATUSG+":"+dataG.size());
		log.info(StockStatus.STATUSH+":"+dataH.size());
		log.info(StockStatus.STATUSI+":"+dataI.size());
		log.info(StockStatus.STATUSJ+":"+dataJ.size());
		
		log.info(StockStatus.STATUSK+":"+dataK.size());
		log.info(StockStatus.STATUSL+":"+dataL.size());
		log.info(StockStatus.STATUSM+":"+dataM.size());
		log.info(StockStatus.STATUSN+":"+dataN.size());
		log.info(StockStatus.STATUSO+":"+dataO.size());
		
		log.info(StockStatus.STATUSP+":"+dataP.size());
		log.info(StockStatus.STATUSQ+":"+dataQ.size());
		log.info(StockStatus.STATUSR+":"+dataR.size());
		log.info(StockStatus.STATUSS+":"+dataS.size());
		log.info(StockStatus.STATUST+":"+dataT.size());
		
	}

}
