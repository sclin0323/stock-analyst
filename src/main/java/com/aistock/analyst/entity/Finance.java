package com.aistock.analyst.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aistock.analyst.status.StockStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "finances")
public class Finance {

	@Id
	String financeId;

	String day;

	String monthStatus;

	String difStatus;

	Double close;

	Double range;

	Integer volume;

	// 個股統計
	Integer statusDifA;

	Integer statusDifB;

	Integer statusDifC;

	Integer statusDifD;

	Integer statusMonthA;

	Integer statusMonthB;

	Integer statusMonthC;

	Integer statusMonthD;

	// 計算
	Integer value1; // 後14日實際漲跌點
	
	Integer value2; // 後2日實際漲跌點
	
	Integer value3; // 後3日實際漲跌點
	
	Integer value4; // 後1日實際漲跌點

	public Integer getValue4() {
		return value4;
	}

	public void setValue4(Integer value4) {
		this.value4 = value4;
	}

	public Integer getValue2() {
		return value2;
	}

	public void setValue2(Integer value2) {
		this.value2 = value2;
	}

	public Integer getValue3() {
		return value3;
	}

	public void setValue3(Integer value3) {
		this.value3 = value3;
	}

	public Integer getValue1() {
		return value1;
	}

	public void setValue1(Integer value1) {
		this.value1 = value1;
	}

	public void setStatusMonthD(int statusMonthD) {
		this.statusMonthD = statusMonthD;
	}

	

	public String getFinanceId() {
		return financeId;
	}

	public void setFinanceId(String financeId) {
		this.financeId = financeId;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getStatusDifA() {
		return statusDifA;
	}

	public void setStatusDifA(Integer statusDifA) {
		this.statusDifA = statusDifA;
	}

	public Integer getStatusDifB() {
		return statusDifB;
	}

	public void setStatusDifB(Integer statusDifB) {
		this.statusDifB = statusDifB;
	}

	public Integer getStatusDifC() {
		return statusDifC;
	}

	public void setStatusDifC(Integer statusDifC) {
		this.statusDifC = statusDifC;
	}

	public Integer getStatusDifD() {
		return statusDifD;
	}

	public void setStatusDifD(Integer statusDifD) {
		this.statusDifD = statusDifD;
	}

	public Integer getStatusMonthA() {
		return statusMonthA;
	}

	public void setStatusMonthA(Integer statusMonthA) {
		this.statusMonthA = statusMonthA;
	}

	public Integer getStatusMonthB() {
		return statusMonthB;
	}

	public void setStatusMonthB(Integer statusMonthB) {
		this.statusMonthB = statusMonthB;
	}

	public Integer getStatusMonthC() {
		return statusMonthC;
	}

	public void setStatusMonthC(Integer statusMonthC) {
		this.statusMonthC = statusMonthC;
	}

	public Integer getStatusMonthD() {
		return statusMonthD;
	}

	public void setStatusMonthD(Integer statusMonthD) {
		this.statusMonthD = statusMonthD;
	}

}