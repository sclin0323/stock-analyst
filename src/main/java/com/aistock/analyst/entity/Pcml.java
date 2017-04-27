package com.aistock.analyst.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "pcmls")
public class Pcml {
	/** 序號 */
	@Id
	String pcmlId;	
	
	String code;

	byte[] bytes;

	public String getPcmlId() {
		return pcmlId;
	}

	public void setPcmlId(String pcmlId) {
		this.pcmlId = pcmlId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
	
	
}