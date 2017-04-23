package com.aistock.analyst.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aistock.analyst.status.StockStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "monthStatuses")
public class MonthStatus {

	@Id
	@JsonIgnore
	ObjectId monthStatusId;
	
	@JsonProperty("日期")
	String date;
	
	@JsonProperty("星期")
	String day;
	
	@JsonProperty(StockStatus.MONTH_STATUSA)
	Integer statusA;
	
	@JsonProperty(StockStatus.MONTH_STATUSB)
	Integer statusB;
	
	@JsonProperty(StockStatus.MONTH_STATUSC)
	Integer statusC;
	
	@JsonProperty(StockStatus.MONTH_STATUSD)
	Integer statusD;
	
	@JsonProperty("加總")
	Integer total;

	public ObjectId getMonthStatusId() {
		return monthStatusId;
	}

	public void setMonthStatusId(ObjectId monthStatusId) {
		this.monthStatusId = monthStatusId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getStatusA() {
		return statusA;
	}

	public void setStatusA(Integer statusA) {
		this.statusA = statusA;
	}

	public Integer getStatusB() {
		return statusB;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setStatusB(Integer statusB) {
		this.statusB = statusB;
	}

	public Integer getStatusC() {
		return statusC;
	}

	public void setStatusC(Integer statusC) {
		this.statusC = statusC;
	}

	public Integer getStatusD() {
		return statusD;
	}

	public void setStatusD(Integer statusD) {
		this.statusD = statusD;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
	
}
