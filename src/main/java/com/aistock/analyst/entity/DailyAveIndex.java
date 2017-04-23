package com.aistock.analyst.entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dailyAveIndexs")
public class DailyAveIndex {

	@Id
	ObjectId dailyAveIndexId;
	
	String date;
	
	String name;
	
	String monthStatus;
	
	String difStatus;
	
	Double range;
	
	Double close;
	
	Integer volume;

	

	public ObjectId getDailyAveIndexId() {
		return dailyAveIndexId;
	}

	public void setDailyAveIndexId(ObjectId dailyAveIndexId) {
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
