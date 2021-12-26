package com.spring.mvc.domain;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class Member {
	
	@NotBlank
	private String userId;
	@NotBlank
	private String password;
	
	@NotBlank @Size(max=3)
	private String username;
	@Email(message="이메일 형식에 맞게 넣으세요")
	private String email;
	
	@Valid
	private Address address;
	@Valid
	private List<Card> cardList;
	
	
	@Past @DateTimeFormat
	private String birthDay;
	private String gender;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", username=" + username + ", email=" + email
				+ ", birthDay=" + birthDay + ", gender=" + gender + "]";
	}
		
}
