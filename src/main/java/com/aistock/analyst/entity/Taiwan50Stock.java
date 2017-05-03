package com.aistock.analyst.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taiwan50Stocks")
public class Taiwan50Stock {

	@Id
	String taiwan50StockId;

	String stockName;
	
	Boolean enabled;
	
	Integer weight;
	
	String note;
	
	
	

	public String getTaiwan50StockId() {
		return taiwan50StockId;
	}

	public void setTaiwan50StockId(String taiwan50StockId) {
		this.taiwan50StockId = taiwan50StockId;
	}

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


	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	
	
}
