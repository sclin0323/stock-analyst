package com.aistock.analyst.entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "otcStocks")
public class OtcStock {

	@Id
	String otcStockId;

	String stockName;
	
	Boolean enabled;
	
	Integer weight;
	
	String note;
	
	

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	

	public String getOtcStockId() {
		return otcStockId;
	}

	public void setOtcStockId(String otcStockId) {
		this.otcStockId = otcStockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	
	
}
