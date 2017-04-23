package com.aistock.analyst.service;

public interface DailyStockService {

	
	public void create(String date, String stockName, String status, Double range, Double close, Integer volume);
	
	public void test();
}
