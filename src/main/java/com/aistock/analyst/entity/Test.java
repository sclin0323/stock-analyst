package com.aistock.analyst.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tests")
public class Test {

	@Id
	String testId;
	
	String name;
	
	String note;

	public String getTestId() {
		return testId;
	}
	

	public void setTestId(String testId) {
		this.testId = testId;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getNote() {
		return note;
	}
	

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
}
