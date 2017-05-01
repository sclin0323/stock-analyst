package com.aistock.analyst.entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dailyStocks")
public class DailyStock {

	@Id
	ObjectId dailyStockId; // Date String
	
	@Transient
	String stockId;
	
	String date;
	
	String stockNum;
	
	String stockName;
	
	String monthStatus;
	
	String difStatus;
	
	String note;
	
	// 漲跌幅
	Double range;
	
	// 收盤價
	Double close;
	
	// 成交量
	Integer volume;
	
	// 成交量累積30天
	Long volumeInvestIn30Days;

	// DIF值
	Double difValue;
	
	// 外資進出
	Long foreignInvest;
	
	// 外資進出累積30天
	Long foreignInvestIn30Days;
	
	// 外資進出累積30天狀態
	String foreignInvestIn30DaysStatus;

	
	
	public String getForeignInvestIn30DaysStatus() {
		return foreignInvestIn30DaysStatus;
	}

	public void setForeignInvestIn30DaysStatus(String foreignInvestIn30DaysStatus) {
		this.foreignInvestIn30DaysStatus = foreignInvestIn30DaysStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getForeignInvestIn30Days() {
		return foreignInvestIn30Days;
	}

	public void setForeignInvestIn30Days(Long foreignInvestIn30Days) {
		this.foreignInvestIn30Days = foreignInvestIn30Days;
	}

	public Long getVolumeInvestIn30Days() {
		return volumeInvestIn30Days;
	}

	public void setVolumeInvestIn30Days(Long volumeInvestIn30Days) {
		this.volumeInvestIn30Days = volumeInvestIn30Days;
	}

	public Double getDifValue() {
		return difValue;
	}

	public void setDifValue(Double difValue) {
		this.difValue = difValue;
	}

	public Long getForeignInvest() {
		return foreignInvest;
	}

	public void setForeignInvest(Long foreignInvest) {
		this.foreignInvest = foreignInvest;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockNum() {
		return stockNum;
	}

	public void setStockNum(String stockNum) {
		this.stockNum = stockNum;
	}

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
