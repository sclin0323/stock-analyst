package com.aistock.analyst.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aistock.analyst.status.StockStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "difStatuses")
public class DifStatus {
	
	@Id
	@JsonIgnore
	ObjectId difStatusId;
	
	@JsonProperty("日期")
	String date;
	
	@JsonProperty("星期")
	String day;
	
	@JsonProperty(StockStatus.DIF_STATUSA)
	Integer statusA;
	
	@JsonProperty(StockStatus.DIF_STATUSB)
	Integer statusB;
	
	@JsonProperty(StockStatus.DIF_STATUSC)
	Integer statusC;
	
	@JsonProperty(StockStatus.DIF_STATUSD)
	Integer statusD;
	
	@JsonProperty("加總")
	Integer total;

	public ObjectId getDifStatusId() {
		return difStatusId;
	}

	public void setDifStatusId(ObjectId difStatusId) {
		this.difStatusId = difStatusId;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getStatusB() {
		return statusB;
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
