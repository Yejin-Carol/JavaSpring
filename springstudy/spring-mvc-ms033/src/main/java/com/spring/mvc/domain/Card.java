package com.spring.mvc.domain;

import org.springframework.format.annotation.DateTimeFormat;

public class Card {

	private String no;
	@DateTimeFormat(pattern="yyMMdd")
	private String validMonth;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getValidMonth() {
		return validMonth;
	}
	public void setValidMonth(String validMonth) {
		this.validMonth = validMonth;
	}
	@Override
	public String toString() {
		return "Card [no=" + no + ", validMonth=" + validMonth + "]";
	}
}
