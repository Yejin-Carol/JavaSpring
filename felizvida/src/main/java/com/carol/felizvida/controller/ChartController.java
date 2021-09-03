package com.carol.felizvida.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carol.felizvida.dto.MemberDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class ChartController {

	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping(value = "/selectmember", method = RequestMethod.GET)
	@ResponseBody
	public String selectmember() {
		
		List<MemberDto> list = sqlsession.selectList("member.select");
				return new Gson().toJson(list);
	}
	/*java class 이용해서 json 문자열 만들기
	 * gson*/
	 
	@RequestMapping(value = "/gsonlib", method = RequestMethod.GET)
	@ResponseBody	
	public String gsonlib() {
		Gson gson = new Gson();
		JsonObject jobj = new JsonObject();
		jobj.addProperty("name", 10);
		jobj.addProperty("age", 10);
		
		String test = gson.toJson(jobj);
		return test;
	}
	
	@RequestMapping(value = "/gsonlib1", method = RequestMethod.GET)
	@ResponseBody	
	public String gsonlib1() {
		Gson gson = new Gson();
		MemberDto dto = new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		String test = gson.toJson(dto);
		return test;
	}
	@RequestMapping(value = "/gsonlib2", method = RequestMethod.GET)
	@ResponseBody	
	public String gsonlib2() {
		Gson gson = new Gson();
		MemberDto dto = new MemberDto();
		dto.setAge(10);
		dto.setId("aa");
		dto.setPw("pw");
		
		String test = gson.toJson(dto);
		
		MemberDto jsontodto = gson.fromJson(test, MemberDto.class);
		System.out.println(jsontodto);
		
		return test;
	}
	
	@RequestMapping(value = "/gsonlib3", method = RequestMethod.GET)
	@ResponseBody	
	public String gsonlib3() {
		Gson gson = new Gson();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		
		MemberDto dto1 = new MemberDto();
		dto1.setAge(10);
		dto1.setId("aa");
		dto1.setPw("pw");
		
		list.add(dto1);

		MemberDto dto2 = new MemberDto();
		dto2.setAge(10);
		dto2.setId("aa");
		dto2.setPw("pw");
		
		list.add(dto2);
		
		MemberDto dto3 = new MemberDto();
		dto3.setAge(10);
		dto3.setId("aa");
		dto3.setPw("pw");
		
		list.add(dto3);
		
		String test = gson.toJson(list);
		return test;
	}
}
