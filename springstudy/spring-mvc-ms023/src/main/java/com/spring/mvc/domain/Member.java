package com.spring.mvc.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	
	private String userId;
	private String password;
	
	//DateTimeFormat
	@DateTimeFormat(pattern = "yyyyMMdd")
	private String dateOfBirth;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
		

}
