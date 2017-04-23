package com.aistock.analyst.calcu;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.aistock.analyst.entity.DifStatus;
import com.aistock.analyst.entity.MonthStatus;
import com.aistock.analyst.repository.DailyStockRepository;
import com.aistock.analyst.repository.DifStatusRepository;
import com.aistock.analyst.repository.MonthStatusRepository;
import com.aistock.analyst.status.StockStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.aistock.analyst.service")
@Import(value = { MongoConfig.class })
public class ImportStatus {
	
	Logger log = LoggerFactory.getLogger(ImportStatus.class);
	
	Integer days = 90;
	
	@Autowired
	DailyStockRepository dailyStockRepository;
	
	@Autowired
	MonthStatusRepository monthStatusRepository;
	
	@Autowired
	DifStatusRepository difStatusRepository;
	
	//@Autowired
	//MonthStatusService monthStatusService;
	
	//@Autowired
//	DifStatusService difStatusService;

	@Test
	public void importMonthStatus() throws Exception{
		
		monthStatusRepository.deleteAll();
		
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dt2 = new SimpleDateFormat("E");
		
		for(int i = 0; i < days; i++) {
			String date = dt1.format(getDate(i));
			String day = dt2.format(getDate(i));
			
			MonthStatus o = new MonthStatus();
			o.setMonthStatusId(new ObjectId());
			o.setDate(date);
			o.setDay(day);
			o.setStatusA(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSA).size());
			o.setStatusB(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSB).size());
			o.setStatusC(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSC).size());
			o.setStatusD(dailyStockRepository.findByDateAndMonthStatus(date,StockStatus.MONTH_STATUSD).size());
			o.setTotal(o.getStatusA()+o.getStatusB()+o.getStatusC()+o.getStatusD());
			
			if(o.getTotal() > 0 ) {
				monthStatusRepository.save(o);
			}
			
		}
		
	}
	
	@Test
	public void importDifStatus() throws Exception{
		
		difStatusRepository.deleteAll();
		
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dt2 = new SimpleDateFormat("E");
		
		for(int i = 0; i < days; i++) {
			String date = dt1.format(getDate(i));
			String day = dt2.format(getDate(i));
			
			DifStatus o = new DifStatus();
			o.setDifStatusId(new ObjectId());
			o.setDate(date);
			o.setDay(day);
			o.setStatusA(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSA).size());
			o.setStatusB(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSB).size());
			o.setStatusC(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSC).size());
			o.setStatusD(dailyStockRepository.findByDateAndDifStatus(date,StockStatus.DIF_STATUSD).size());
			o.setTotal(o.getStatusA()+o.getStatusB()+o.getStatusC()+o.getStatusD());
			
			if(o.getTotal() > 0 ) {
				difStatusRepository.save(o);
			}
		}
		
	}
	
	private Date getDate(int i) {
	    final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, i*-1);
	    return cal.getTime();
	}
}
