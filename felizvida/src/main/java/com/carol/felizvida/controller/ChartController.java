package com.carol.felizvida.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carol.felizvida.dto.MemberDto;

@Controller
public class ChartController {

	
	@RequestMapping(value = "/testjson", method = RequestMethod.GET)
	@ResponseBody
	public String testjson() {	
		int[] myages = {10, 20, 25, 15, 3};
		
		return "[ \r\n"
				+ "  {\"name\": \"Tom\", \"ages\": "+myages[0]+" },\r\n"
				+ "  {\"name\": \"Franz\", \"age\":"+myages[1]+"},\r\n"
				+ "  {\"name\": \"Chris Calip\", \"age\":"+myages[2]+"},\r\n"
				+ "  {\"name\": \"Maria\", \"age\": 30 },\r\n"
				+ "  {\"name\": \"Fred\", \"age\": 50 },\r\n"
				+ "  {\"name\": \"R Stallman\", \"age\": 60 }\r\n"
				+ "]";
	}
}
