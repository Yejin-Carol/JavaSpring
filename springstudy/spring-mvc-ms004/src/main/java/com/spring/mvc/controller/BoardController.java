package com.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="board")
public class BoardController {
	
	//1. registerForm()
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm() {
		
		return "board/register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register() {
		return "board/success";
	}
		
	//2. modifyForm()
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm() {
		
		return "board/modify";
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify() {
		return "board/success";
	}
	
	//ms004 remove() 추가
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(HttpServletRequest request) {
		return "board/success";
	}
		
	
	//3. list()
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		return "board/list";
	}
	//4. read() 
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String read(@RequestParam(value="boardNo") int boardNo) {
		return "board/read";
		
	}
}
