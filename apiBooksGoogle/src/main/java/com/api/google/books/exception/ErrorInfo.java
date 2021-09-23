package com.api.google.books.exception;

public class ErrorInfo {

	private int codeError;
	private String messageError;
	
	public ErrorInfo(int i, String messageError) {
		this.codeError = i;
		this.messageError = messageError;
	}
	
	public int getCodeError() {
		return codeError;
	}
	public void setCodeError(int codeError) {
		this.codeError = codeError;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

}
