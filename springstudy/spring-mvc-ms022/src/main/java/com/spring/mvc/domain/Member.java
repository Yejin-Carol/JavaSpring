package com.spring.mvc.domain;

public class Member {
	
	private String userId;
	private String password;
	private int coin;
	
	
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
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", coin=" + coin + "]";
	}

}
