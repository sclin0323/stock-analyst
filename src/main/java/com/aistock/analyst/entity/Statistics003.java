package com.aistock.analyst.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "statistics003s")
public class Statistics003 {

	@Id
	String statistics003Id;
	String investStatus;
	String difStatus;
	String monthStatus;
	
	Integer upAfter25Days;
	Integer downAfter25Days;
	Integer up3_5perAfter25Days;
	Integer down3_5perAfter25Days;
	Integer up7perAfter25Days;
	Integer down7perAfter25Days;
	Integer up10perAfter25Days;
	Integer down10perAfter25Days;
	
	Double sumRange;
	Integer total;
	
	
	
	public Integer getUp3_5perAfter25Days() {
		return up3_5perAfter25Days;
	}
	public void setUp3_5perAfter25Days(Integer up3_5perAfter25Days) {
		this.up3_5perAfter25Days = up3_5perAfter25Days;
	}
	public Integer getDown3_5perAfter25Days() {
		return down3_5perAfter25Days;
	}
	public void setDown3_5perAfter25Days(Integer down3_5perAfter25Days) {
		this.down3_5perAfter25Days = down3_5perAfter25Days;
	}
	public Integer getUp10perAfter25Days() {
		return up10perAfter25Days;
	}
	public void setUp10perAfter25Days(Integer up10perAfter25Days) {
		this.up10perAfter25Days = up10perAfter25Days;
	}
	public Integer getDown10perAfter25Days() {
		return down10perAfter25Days;
	}
	public void setDown10perAfter25Days(Integer down10perAfter25Days) {
		this.down10perAfter25Days = down10perAfter25Days;
	}
	public Integer getUp7perAfter25Days() {
		return up7perAfter25Days;
	}
	public void setUp7perAfter25Days(Integer up7perAfter25Days) {
		this.up7perAfter25Days = up7perAfter25Days;
	}
	public Integer getDown7perAfter25Days() {
		return down7perAfter25Days;
	}
	public void setDown7perAfter25Days(Integer down7perAfter25Days) {
		this.down7perAfter25Days = down7perAfter25Days;
	}
	public Double getSumRange() {
		return sumRange;
	}
	public void setSumRange(Double sumRange) {
		this.sumRange = sumRange;
	}
	public Integer getUpAfter25Days() {
		return upAfter25Days;
	}
	public void setUpAfter25Days(Integer upAfter25Days) {
		this.upAfter25Days = upAfter25Days;
	}
	public Integer getDownAfter25Days() {
		return downAfter25Days;
	}
	public void setDownAfter25Days(Integer downAfter25Days) {
		this.downAfter25Days = downAfter25Days;
	}
	public String getMonthStatus() {
		return monthStatus;
	}
	public void setMonthStatus(String monthStatus) {
		this.monthStatus = monthStatus;
	}
	public String getStatistics003Id() {
		return statistics003Id;
	}
	public void setStatistics003Id(String statistics003Id) {
		this.statistics003Id = statistics003Id;
	}
	public String getInvestStatus() {
		return investStatus;
	}
	public void setInvestStatus(String investStatus) {
		this.investStatus = investStatus;
	}
	public String getDifStatus() {
		return difStatus;
	}
	public void setDifStatus(String difStatus) {
		this.difStatus = difStatus;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
