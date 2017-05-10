package com.aistock.analyst.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dailyAveIndexs")
public class DailyAveIndex {

	@Id
	String dailyAveIndexId;
	
	@Indexed
	String date;
	
	String name;
	
	@Indexed
	String monthStatus;
	
	@Indexed
	String difStatus;
	
	Double range;
	
	Double close;
	
	Integer volume;

	public String getDailyAveIndexId() {
		return dailyAveIndexId;
	}

	public void setDailyAveIndexId(String dailyAveIndexId) {
		this.dailyAveIndexId = dailyAveIndexId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMonthStatus() {
		return monthStatus;
	}

	public void setMonthStatus(String monthStatus) {
		this.monthStatus = monthStatus;
	}

	public String getDifStatus() {
		return difStatus;
	}

	public void setDifStatus(String difStatus) {
		this.difStatus = difStatus;
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
