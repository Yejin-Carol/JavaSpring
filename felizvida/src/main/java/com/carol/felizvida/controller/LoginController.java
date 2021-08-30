package com.carol.felizvida.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carol.felizvida.dao.MemberDao;
import com.carol.felizvida.dto.MemberDto;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberDao dao;
	
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String logincheck(MemberDto dto, HttpSession session) {	
		/*login check
		 * mybatis sqllog*/
		dto = dao.chklogin(dto);

		if (dto != null) {
			//session에 저장, 세션: 
			session.setAttribute("dto", dto);
			return "chart"; 
		}
		else {
			//로그인에 실패 하였습니다. 아이디, 비밀번호를 확인하세요.
			return "redirect:/?text=loginfail";
	}
}
}
