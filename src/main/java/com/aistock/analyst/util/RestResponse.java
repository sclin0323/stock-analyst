package com.aistock.analyst.util;


public class RestResponse {
	
	public static final int STATUS_SUCCESS = 0;
	public static final int STATUS_FAILURE = -1;

	Boolean success;
	Object data;
	Long total;
	String message;
	Integer status;
	
	public static RestResponse success(Object data){
		RestResponse response = new RestResponse();
		response.success = Boolean.TRUE;
		response.status = STATUS_SUCCESS;
		response.data = data;
		return response;
	}
	
	public static RestResponse success(Object data, long total){
		RestResponse response = new RestResponse();
		response.success = Boolean.TRUE;
		response.status = STATUS_SUCCESS;
		response.data = data;
		response.total = total;
		return response;
	}
	
	public static RestResponse failure(String message){
		RestResponse response = new RestResponse();
		response.success = Boolean.FALSE;
		response.status = STATUS_FAILURE;
		response.message = message;
		return response;
	}
	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
