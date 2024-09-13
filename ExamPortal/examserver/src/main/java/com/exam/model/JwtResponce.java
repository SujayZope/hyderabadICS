package com.exam.model;

public class JwtResponce {

	String token;

	public JwtResponce(String token) {
		this.token = token;
	}

	public JwtResponce() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
