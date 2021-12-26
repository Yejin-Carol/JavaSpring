package com.spring.mvc.domain;

public class Address {

	private String postcode;
	private String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Address [postcode=" + postcode + ", location=" + location + "]";
	}
	
}
