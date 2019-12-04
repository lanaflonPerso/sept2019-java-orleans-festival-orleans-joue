package com.wildcodeschool.festivalorleansjoue.services;

public class ErrorMsgModel {
	
	private boolean errorON = false;
	private String errorMsg;
	private String errorDescription;
	
	public ErrorMsgModel(boolean errorON, String errorMsg, String errorDescription) {
		
		this.errorON = errorON;
		this.errorMsg = errorMsg;
		this.errorDescription = errorDescription;
	}
	
	
	public ErrorMsgModel(String errorMsg) {
		
		this.errorON = true;
		this.errorMsg = errorMsg;
	}
	
	
	public ErrorMsgModel() {

	}
	
	
	public boolean isErrorON() {
		
		return this.errorON;
	}


	public void setErrorON(boolean errorON) {
		
		this.errorON = errorON;
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
