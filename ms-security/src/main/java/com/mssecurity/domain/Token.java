package com.mssecurity.domain;

public class Token{
    private String Token;
    private User user;
    
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
}
