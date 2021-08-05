package com.api.store.dto;


public class ErrorDto {
 
	private Integer errorcode;
	
	private String errorMessage;

	
	
	
	public ErrorDto(Integer errorcode, String errorMessage) {
		super();
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}

	public ErrorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

	@Override
	public String toString() {
		return "ErrorDto [errorcode=" + errorcode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
	
}
