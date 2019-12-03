package com.wildcodeschool.festivalorleansjoue.entity;

public class ErrorMsgModel {
	
	private String errorMsg;
	private String errorDescription;
	
	public ErrorMsgModel(String errorMsg, String errorDescription) {
		
		this.errorMsg = errorMsg;
		this.errorDescription = errorDescription;
	}
	
	
	public ErrorMsgModel(String errorMsg) {
		
		this.errorMsg = errorMsg;
	}


	public String getErrorMsg() {
		
		return this.errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		
		this.errorMsg = errorMsg;
	}


	public String getErrorDescription() {
		
		return this.errorDescription;
	}


	public void setErrorDescription(String errorDescription) {
		
		this.errorDescription = errorDescription;
	}
	
	
	
}
