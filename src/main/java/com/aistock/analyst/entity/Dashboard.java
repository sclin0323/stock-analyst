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
	@JsonIgnore
	ObjectId dashboardId;
	
	@JsonProperty("日期")
	String date;
	
	@JsonProperty("星期")
	String day;
	
	@JsonProperty("大盤收盤")
	Double tesClose;
	
	@JsonProperty("美股收盤")
	Double djiClose;
	
	@JsonProperty("月線狀態")
	String monthStatus;
	
	@JsonProperty("DIF狀態")
	String difStatus;
	
	@JsonProperty("收盤價")
	Double close;
	
	@JsonProperty("漲跌點")
	Double range;
	
	@JsonProperty("成交量")
	Integer volume;
	
	@JsonProperty(StockStatus.DIF_STATUSA)
	Integer statusDifA;
	
	@JsonProperty(StockStatus.DIF_STATUSB)
	Integer statusDifB;
	
	@JsonProperty(StockStatus.DIF_STATUSC)
	Integer statusDifC;
	
	@JsonProperty(StockStatus.DIF_STATUSD)
	Integer statusDifD;
	
	@JsonProperty(StockStatus.MONTH_STATUSA)
	Integer statusMonthA;
	
	@JsonProperty(StockStatus.MONTH_STATUSB)
	Integer statusMonthB;
	
	@JsonProperty(StockStatus.MONTH_STATUSC)
	Integer statusMonthC;
	
	@JsonProperty(StockStatus.MONTH_STATUSD)
	Integer statusMonthD;
	
	@JsonProperty("狀態總數")
	Integer total;

	public ObjectId getDashboardId() {
		return dashboardId;
	}

	public void setDashboardId(ObjectId dashboardId) {
		this.dashboardId = dashboardId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Double getTesClose() {
		return tesClose;
	}

	public void setTesClose(Double tesClose) {
		this.tesClose = tesClose;
	}

	public Double getDjiClose() {
		return djiClose;
	}

	public void setDjiClose(Double djiClose) {
		this.djiClose = djiClose;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
	
	
	
}
