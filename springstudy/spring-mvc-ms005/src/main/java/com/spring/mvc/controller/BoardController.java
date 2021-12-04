package com.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//1) registerForm() /get?register, GET
	/* Mission 5 */	
	@RequestMapping(value= "/get", method = RequestMethod.GET, params="register")
	public String registerForm() {
		logger.info("registerForm");
		
		return "board/register";
	}
	//2) register() /post?register, POST
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="register")
	public String register() {
		logger.info("register");
		
		return "board/list";
	}
	//3) modifyFomr() /get?modify, GET
	@RequestMapping(value= "/get", method = RequestMethod.GET, params="modify")
	public String modifyForm() {
		logger.info("modifyForm");
		
		return "board/modify";
	}
		
	//4) moidfy() /post?moidify, POST
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="modify")
	public String modify() {
		logger.info("modify");
		
		return "board/list";
	}
	
	//5) removeForm() /get?remove, GET
	@RequestMapping(value= "/get", method = RequestMethod.GET, params="remove")
	public String removeForm() {
		logger.info("removeForm");
		
		return "board/remove";
	}
	
	//6) remove() /post?remove, POST
	@RequestMapping(value = "/post", method = RequestMethod.POST, params="remove")
	public String remove() {
		logger.info("remove");
		
		return "board/list";
	}
	
	//7) list() /get?list, GET
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="list")
	public String list() {
		logger.info("list");
		return "board/list";
	}
	//8) read(int boardNo) /get?read, GET
	@RequestMapping(value = "/get", method = RequestMethod.GET, params="read")
	public String read() {
		logger.info("read");
		return "board/read";
	}

}
