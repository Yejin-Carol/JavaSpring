package com.spring.mvc.domain;

import jakarta.validation.Valid;

public class Address {
	
	private String postcode;
	private String location;
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
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
