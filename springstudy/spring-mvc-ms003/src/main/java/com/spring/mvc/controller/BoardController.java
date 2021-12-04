package com.spring.mvc.controller;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="board")
public class BoardController {
	
	//private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	//1. registerForm()
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm(Model model) {
		
		return "board/register";
	}

	//2. modifyForm()
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(Model model) {
		
		return "board/modify";
	}
	
	//3. list()
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		return "board/list";
	}
	//4. read() -ms003
		@RequestMapping(value="/read/{boardNo}", method=RequestMethod.GET)
		public String read(@PathVariable("boardNo") int boardNo) {
//			Logger.info("조회화면 boardNo : " + boardNo);
			
			return "board/read";
		}
	
	
}
