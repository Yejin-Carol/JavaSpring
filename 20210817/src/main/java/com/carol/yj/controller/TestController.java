package com.carol.yj.controller;
/*
 * controller(requestMapping) -> TestDao -> TestDto -> b.xml
 * mybatis 설정, 게시판 만들기, Spring, 회원가입
 * view = html, css, javascript, jquery, d3js
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.carol.yj.dao.TestDao;
import com.carol.yj.dto.TestDto;

@Controller
public class TestController {

	@Autowired
	TestDao dao = new TestDao();
	
//	@Autowired
//	DriverManagerDataSource dataSource;
//	model 사용방법
// 값을 가지고 jsp 페이지로 이동
	@RequestMapping(value="list")
	public String list(Model model) {
		List<TestDto> rvalue = dao.doList();
		model.addAttribute("a", rvalue); //rvalue는 list.jsp
		

		return "list";
	}
	//insert?para1=555&para2=333 (URL 변수가 똑같으면 가져옴)
	@RequestMapping(value="insert")
	public String insert(Model model, HttpServletRequest request, 
						@RequestParam String para1, String para2) {
		String va1 = request.getParameter("para1");
		System.out.println(va1);
		System.out.println("para1 = " + para1);
		System.out.println("para2 = " + para2);
		dao.doInsert(para1,para2);
		return "insert";
	}
	
	@RequestMapping(value="insertform")
	public String insertform() {
		return "insertform";
	}
}