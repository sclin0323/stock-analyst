package com.aistock.analyst.entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dailyStocks")
public class DailyStock {

	@Id
	ObjectId dailyStockId; // Date String
	
	String date;
	
	String stockName;
	
	String status;
	
	Double range;
	
	Double close;
	
	Integer volume;

	

	public ObjectId getDailyStockId() {
		return dailyStockId;
	}

	public void setDailyStockId(ObjectId dailyStockId) {
		this.dailyStockId = dailyStockId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	
	
	
	
}
