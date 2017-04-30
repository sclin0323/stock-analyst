package com.aistock.analyst.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aistock.analyst.status.StockStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "dashboards")
public class Dashboard {

	@Id
	String dashboardId;	// Date

	String day;

	String monthStatus;

	String difStatus;

	Double close;

	Double range;

	Integer volume;

	Integer statusDifA;		// DIF持續走多

	Integer statusDifB;		// DIF由多轉空

	Integer statusDifC;		// DIF持續走空

	Integer statusDifD;		// DIF由空轉多

	Integer statusMonthA;	// 月上季上

	Integer statusMonthB;	// 月下季上

	Integer statusMonthC;	// 月下季下

	Integer statusMonthD;	// 月上季下

	// 計算
	Integer after14Days; // 後14日實際漲跌點
	
	Integer after2Days; // 後2日實際漲跌點
	
	Integer after3Days; // 後3日實際漲跌點
	
	Integer after1Days; // 後1日實際漲跌點
	
	//Integer difAUntilDays; // 隔天連續出現DIF天數
	
	//Integer difAUntilDays; // 隔天連續出現DIF天數


	public Integer getAfter14Days() {
		return after14Days;
	}

	public void setAfter14Days(Integer after14Days) {
		this.after14Days = after14Days;
	}

	public Integer getAfter2Days() {
		return after2Days;
	}

	public void setAfter2Days(Integer after2Days) {
		this.after2Days = after2Days;
	}

	public Integer getAfter3Days() {
		return after3Days;
	}

	public void setAfter3Days(Integer after3Days) {
		this.after3Days = after3Days;
	}

	public Integer getAfter1Days() {
		return after1Days;
	}

	public void setAfter1Days(Integer after1Days) {
		this.after1Days = after1Days;
	}

	public String getDashboardId() {
		return dashboardId;
	}

	public void setStatusMonthD(int statusMonthD) {
		this.statusMonthD = statusMonthD;
	}

	public void setDashboardId(String dashboardId) {
		this.dashboardId = dashboardId;
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
